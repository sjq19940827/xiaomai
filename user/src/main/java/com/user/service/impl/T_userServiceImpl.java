package com.user.service.impl;

import com.user.dao.T_userDao;
import com.user.pojo.T_user;
import com.user.service.T_userService;
import com.user.util.httpApiDemo.IndustrySMS;
import com.user.util.md5.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("TSI")
public class T_userServiceImpl implements T_userService{

    @Autowired
    private T_userDao tud;
    public T_userDao getTud() {
        return tud;
    }
    public void setTud(T_userDao tud) {
        this.tud = tud;
    }

    /**
     * 发送验证码
     * @param phone 用户登录输入的手机号
     * @return 发送结果
     */
    @Override
    public String judgeUserExist(String phone/*,HttpServletRequest request*/) {
       // HttpSession session=request.getSession();
        Jedis jedis = new Jedis("localhost",6379);
        T_user user = new T_user();
        if(JudgeMobilePhoneLegal(phone)){
            IndustrySMS.execute(phone/*,request*/);
            jedis.set("phones",phone);
            /*session.setAttribute("phones",phone);*/
            return "已发送";
        }else {
            return "未发送，手机号不合法，请输入正确的手机号";
        }
    }

    /**
     * 判断用户输入手机号的合法性
     * @param phone 用户输入的手机号
     * @return 返会判断结果
     */
    public boolean JudgeMobilePhoneLegal(String phone){
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$" ;
        if(phone.length() == 11){
            System.out.println(1);
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phone);
            boolean judgephone = matcher.matches();
            System.out.println(judgephone);
            if(judgephone == true){
                return true;
            }else {
                System.out.println(2);
                return false;
            }
        }else {
            System.out.println(3);
            return false;
        }
    }

    /**
     * 新增一条用户信息到数据库
     * @param phone 用户登录输入的手机号
     * @return 返回新增结果
     */
    @Override
    public String adduser(String phone) {
        if(JudgeMobilePhoneLegal(phone)){
            T_user user = new T_user();
            user.setLogin_phone(phone);
            user.setId(0);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            user.setLatelyLogin(df.format(System.currentTimeMillis()));
            user.setUsertype(0);
            user.setNickname("用户" + phone + "wOrGe");
            if(tud.addUser(user) > 0){
                return "success";
            }else {
                return "error";
            }
        }else {
            return "用户已存在";
        }
    }
    /**
     * 判断用户输入的验证码是否正确
     * 手机号、验证码登录登录登录登录登录登录登录登录登录登录登录登录登录登录登录登录
     * @param authcode 验证码
     * @return 返回登录结果
     */
    @Override
    public String judgeAuthcode(String authcode/*,HttpServletRequest request*/) {
        Jedis jedis = new Jedis("localhost",6379);
       /* HttpSession session=request.getSession();*/
       /* String phone = (String) session.getAttribute("phones");*/
        String phone = jedis.get("phones");
        System.out.println(phone+"phone");
        if(authcode.length() == 6){
            System.out.println(jedis.get("authcode") + "111111111111111");
            if(authcode.equals(jedis.get("authcode"))){
                T_user user = new T_user();
                user.setLogin_phone(phone);
                if(tud.seleUser(user) == null){
                    adduser(phone);
                }
                String loginstate = "loginsucceed";
                jedis.set("loginstate",loginstate);
                jedis.set("loginphone",phone);
                String userid = String.valueOf(tud.seleUser(user).getId());
                jedis.set("userid",userid);
                //session.setAttribute("loginstate",loginstate);
                return "y";//登录成功
            }else {
                return "验证码错误";
            }
        }else {
            return "不是正确的验证码";
        }
    }

    /**
     * 通过手机号，密码，验证码新增一条数据
     * @param authcode 验证码
     * @return
     */
    @Override
    public String addUserPwd(String authcode/*,HttpServletRequest request*/) {
       /* HttpSession session=request.getSession();*/
        Jedis jedis = new Jedis("localhost",6379);
        T_user user = new T_user();
        if(authcode.length() == 6){
            if(authcode.equals(/*session.getAttribute("authcode")*/jedis.get("authcode"))){
                /*String pwd = (String) session.getAttribute("pwd");*/
                String pwd = jedis.get("pwd");

                System.out.println(pwd);
                /*user.setPassword((String) session.getAttribute("pwd"));
                user.setLogin_phone((String) session.getAttribute("phone"));*/
                user.setPassword(jedis.get("pwd"));
                user.setLogin_phone(jedis.get("phone"));
                user.setId(0);
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                user.setLatelyLogin(df.format(System.currentTimeMillis()));
                user.setUsertype(0);
                user.setNickname("用户" + /*session.getAttribute("phone")*/jedis.get("phone") + "wOrGe");
                if(tud.addUserPwd(user) > 0){
                    return "注册成功";
                }else {
                    return "error";
                }
            }else {
                return "验证码错误";
            }
        }else {
            return "验证码不等于6位";
        }

    }

    /**
     * 判断手机号的和法性，以及手否已经被注册
     * @param phone 手机号
     * @param pwd1 密码1
     * @param pwd2 密码2
     * @return 返回验证结果
     */
    @Override
    public String judgePhoneAndPwd(String phone, String pwd1, String pwd2/*,HttpServletRequest request*/) {
        /*HttpSession session=request.getSession();*/
        Jedis jedis = new Jedis("localhost",6379);
        T_user user = new T_user();
        if(!judgepwd(pwd1,pwd2).equals("y")){
            return judgepwd(pwd1,pwd2);
        }else {
            String pwd = SecurityUtils.md5Hex3(pwd1);
            /*session.setAttribute("pwd",pwd);*/
            jedis.set("pwd",pwd);
            System.out.println(pwd);
           /* System.out.println(session.getAttribute("pwd"));*/
            System.out.println(jedis.get("pwd"));
            if(judge(phone).equals("y")){
                /*session.setAttribute("phone",phone);*/
                jedis.set("phone",phone);
                return "yes";
            }else {
                return judge(phone);
            }
        }
    }

    /**
     * 发送验证码，手机号密码注册
     * @return
     */
    @Override
    public String getAuthcode(/*HttpServletRequest request*/) {
        /*HttpSession session=request.getSession();*/
        /*String phone = (String) session.getAttribute("phone");*/
        Jedis jedis = new Jedis("localhost",6379);
        String phone = jedis.get("phone");
        System.out.println(phone + "1111111");
        IndustrySMS.execute(phone/*,request*/);
        return phone;
    }

    /**
     * 手机号密码登录  登录登录登录登录登录登录登录登录登录登录登录登录
     * @param phone 账号
     * @param pwd 密码
     * @return 返回登录状态
     */
    @Override
    public String phoneAndPwdLogin(String phone, String pwd/*,HttpServletRequest request*/) {
        /*HttpSession session=request.getSession();*/
        Jedis jedis = new Jedis("localhost",6379);
        if(!JudgeMobilePhoneLegal(phone)){
            return "手机号不合法，请输入正确的手机号";
        }else {
            T_user user = new T_user();
            user.setLogin_phone(phone);
            if(tud.seleUser(user) == null){
                return "没有该用户请注册";
            }else {
                String password = SecurityUtils.md5Hex3(pwd);
                if(password.equals(tud.seleUser(user).getPassword())){
                    String loginstate = "loginsucceed";
                    jedis.set("loginstate",loginstate);//登录状态
                    jedis.set("loginphone",phone);//用户账号
                    jedis.set("loginpwd",password);//用户密码
                    String userid = String.valueOf(tud.seleUser(user).getId());
                    jedis.set("userid",userid);//用户id
                    return "loginyes";
                }else {
                    return "loginerror";
                }
            }
        }
    }

    /**
     * 注销
     * @return
     */
    @Override
    public String userLogout() {
        Jedis jedis = new Jedis("localhost",6379);
        String loginstate = "logout";
        jedis.set("loginstate",loginstate);
        jedis.set("loginphone","null");
        return "注销成功";
    }


    /**
     *  判断手机号的合法性以及验证是否已经注册过
     * @param phone 手机号
     * @return 判断结果
     */
    public String judge(String phone){
        T_user user = new T_user();
       if(JudgeMobilePhoneLegal(phone)){ //判断手机号的合法性
            user.setLogin_phone(phone);
            if(tud.seleUser(user) != null){
                return "已存在该用户，请使用使用密码或者快速登录";
            }else {
                return "y";//该手机号通过验证
            }
       }else {
           return "用户输入的手机号不合法";
       }
    }

    /**
     * 判断两次密码的正确性
     * @param pwd1
     * @param pwd2
     * @return
     */
    public String judgepwd(String pwd1, String pwd2){
        if(!(pwd1.length() <= 16 && pwd2.length() <= 16)){
            return "密码长度不能超过16位，请输入合理密码";

        }else {
            if(!pwd1.equals(pwd2)){
                return "两次密码不一致，请重新输入密码";
            }else {
                return "y";
            }
        }
    }


}
