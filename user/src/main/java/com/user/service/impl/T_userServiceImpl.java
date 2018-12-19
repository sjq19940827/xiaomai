package com.user.service.impl;

import com.user.dao.T_userDao;
import com.user.pojo.T_user;
import com.user.service.T_userService;
import com.user.util.httpApiDemo.IndustrySMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * 判断用户手机号是否存在
     * @param phone 用户登录输入的手机号
     * @return 返回查询结果，true 存在该用户，false该用户不存在
     */
    @Override
    public String judgeUserExist(String phone) {
        T_user user = new T_user();
        if(JudgeMobilePhoneLegal(phone)){
            IndustrySMS.execute(phone);
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
    public static boolean JudgeMobilePhoneLegal(String phone){
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
     * @param authcode
     * @return
     */
    @Override
    public String judgeAuthcode(String authcode,String phone) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();
        if(authcode.length() == 6){
            IndustrySMS industrySMS = new IndustrySMS();
            System.out.println(session.getAttribute("authcode"));
            if(authcode.equals(session.getAttribute("authcode"))){
                T_user user = new T_user();
                user.setLogin_phone(phone);
                if(tud.seleUser(user) == null){
                    adduser(phone);
                }
                return "y";//登录成功
            }else {
                return "验证码错误";
            }
        }else {
            return "不是正确的验证码";
        }
    }
}
