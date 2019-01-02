package com.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.user.dao.T_userInfoDao;
import com.user.pojo.T_user;
import com.user.service.T_userInfoService;
import com.user.util.md5.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
@Service("TIService")
public class T_userInfoServiceImpl implements T_userInfoService {
    @Autowired
    private T_userInfoDao tuid;
    public T_userInfoDao getTuid() {
        return tuid;
    }
    public void setTuid(T_userInfoDao tuid) {
        this.tuid = tuid;
    }

    /**
     * 用户第一次修改密码
     * @param pwd1 新密码
     * @param pwd2  再次输入密码
     * @return 返回结果
     */
    @Override
    public String updaFirstPwd(String pwd1, String pwd2) {
        Jedis jedis = new Jedis("148.70.68.230",6379);
        String phone = jedis.get("loginphone");
        T_user user = new T_user();
        user.setLogin_phone(phone);
        if(judgePwdLegal(pwd1, pwd2).equals("yi")){
            String pwd = SecurityUtils.md5Hex3(pwd1);
            user.setPassword(pwd);
            int judge = tuid.updaUserPwd(user);
            if(judge > 0){
                return "修改成功";
            }else {
                return "修改失败";
            }
        }else {
            return judgePwdLegal(pwd1, pwd2);
        }
    }

    /**
     * 修改密码
     * @param pwd 旧密码
     * @param pwd2 新密码
     * @param pwd3 再次输入密码
     * @return 返回修改结果
     */
    @Override
    public String updaPwd(String pwd, String pwd2, String pwd3) {
        T_user user = new T_user();
        Jedis jedis = new Jedis("148.70.68.230",6379);
        if(judgepwdexist(pwd).equals("ye")){
            String pwds = SecurityUtils.md5Hex3(pwd);
            if(judgePwdLegal(pwd2,pwd3).equals("yi")){
                String newpwd = SecurityUtils.md5Hex3(pwd2);
                if(newpwd.equals(pwds)){
                    return "新密码与旧密码不能一样";
                }else {
                    user.setLogin_phone(jedis.get("loginphone"));
                    user.setPassword(newpwd);
                    int judge = tuid.updaUserPwd(user);
                    if(judge > 0){
                        return "修改成功";
                    }else {
                        return "修改失败";
                    }
                }
            }else {
                return judgePwdLegal(pwd2,pwd3);
            }
        }else {
            return judgepwdexist(pwd);
        }
    }

    /**
     * 用户修改信息
     * @param nickname 昵称
     * @param personalizedSignature 个性签名
     * @return 修改结果
     */
    @Override
    public String updaUserInfo(String nickname,  String personalizedSignature) {
        T_user user = new T_user();
        Jedis jedis = new Jedis("148.70.68.230",6379);
        if(nickname.length() > 10){
            return "不能超过10个字";
        }else {
            user.setNickname(nickname);
        }
        if(personalizedSignature.length() > 20){
            return "不能超过20个字";
        }else {
            user.setLoginName(personalizedSignature);
        }
        user.setLogin_phone(jedis.get("loginphone"));
        int judge = tuid.updaUserInfo(user);
        if(judge > 0){
            return "保存成功";
        }else {
            return "保存失败";
        }
    }

    /**
     * 判断用户有没有密码
     *
     * @return 返回判断结果
     */
    @Override
    public String judgeUserExistPwd() {
        Jedis jedis = new Jedis("148.70.68.230",6379);
        String phone = jedis.get("loginphone");
        T_user user = new T_user();
        user.setLogin_phone(phone);
        if(tuid.seleinfo(user).getPassword() == null){
            return "first";
        }else {
            return "existpwd";
        }
    }

    /**
     * 展示用户信息
     * @return 返回结果
     */
    @Override
    public String userInfo() {
        Jedis jedis = new Jedis("148.70.68.230",6379);
        T_user user = new T_user();
        user.setLogin_phone(jedis.get("loginphone"));
        String userinfo = JSON.toJSONString(tuid.seleinfo(user));
        return userinfo;
    }

    /**
     * 判断密码的合法性
     * @param pwd1 新密码
     * @param pwd2 再次输入密码
     * @return 返回判断结果
     */
    public String judgePwdLegal(String pwd1,String pwd2){
        if((pwd1.length() < 5 || pwd1.length() > 20) || (pwd2.length() < 5 || pwd2.length() > 20)){
            return "密码不合法";
        }else {
            if(!pwd1.equals(pwd2)){
                return "密码不一致";
            }else {
                return "yi";
            }
        }
    }

    /**
     * 判断密码的
     * @param pwd
     * @return
     */
    public String judgepwdexist(String pwd){
        Jedis jedis = new Jedis("148.70.68.230",6379);
        T_user user = new T_user();
        user.setLogin_phone(jedis.get("loginphone"));
        if(pwd.length() < 6 || pwd.length() > 20){
            return "密码不合法";
        }else {
            String pwds = SecurityUtils.md5Hex3(pwd);
            if(tuid.seleinfo(user).getPassword().equals(pwds)){
                return "ye";
            }else {
                return "密码错误";
            }
        }
    }
}
