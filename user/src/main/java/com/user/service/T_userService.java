package com.user.service;

public interface T_userService {
    /**
     * 查询数据库判断该用户是否存在
     * @param phone 用户登录输入的手机号
     * @return 返回查询结果
     */
    String judgeUserExist(String phone);

    /**
     * 新增一个用户
     * @param phone 用户登录输入的手机号
     * @return 返回新增结果
     */
    String adduser(String phone);

    /**
     * 判断验证码是否正确
     * @param authcode
     * @param phone
     * @return
     */
    String judgeAuthcode(String authcode,String phone);
}
