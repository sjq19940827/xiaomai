package com.user.service;

public interface T_userService {
    /**
     * 查询数据库判断该用户是否存在
     * @param phone 用户登录输入的手机号
     * @return 返回查询结果
     */
    String judgeUserExist(String phone/*,HttpServletRequest request*/);

    /**
     * 新增一个用户
     * @param phone 用户登录输入的手机号
     * @return 返回新增结果
     */
    String adduser(String phone);

    /**
     * 判断验证码是否正确
     * @param authcode
     * @return
     */
    String judgeAuthcode(String authcode/*, HttpServletRequest request*/);

    /**
     * 通过手机号，密码，验证码来新增一个用户
     * @param authcode 验证码
     * @return 返回新增结果
     */
    String addUserPwd(String authcode/*,HttpServletRequest request*/);

    /**
     * 验证手机号密码是否合法
     * @param phone 手机号
     * @param pwd1 密码1
     * @param pwd2 密码2
     * @return 返回验证结果
     */
    String judgePhoneAndPwd(String phone,String pwd1,String pwd2/*,HttpServletRequest request*/);

    /**
     * 发送验证码
     * @return
     */
    String getAuthcode(/*HttpServletRequest request*/);

    /**
     * 手机号密码登录
     * @param phone
     * @param pwd
     * @return
     */
    String phoneAndPwdLogin(String phone,String pwd/*,HttpServletRequest request*/);
}
