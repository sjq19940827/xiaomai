package com.user.service;

public interface T_userInfoService {

    /**
     * 第一次修改密码
     * @param pwd1 新密码
     * @param pwd2  再次输入密码
     * @return 返回修改结果
     */
    String updaFirstPwd(String pwd1, String pwd2);

    /**
     * 修改密码
     * @param pwd 旧密码
     * @param pwd2 新密码
     * @param pwd3 再次输入密码
     * @return 返回修改结果
     */
    String updaPwd(String pwd,String pwd2,String pwd3);

    /**
     * 修改个人信息
     * @param nickname 昵称
     * @param personalizedSignature 个性签名
     * @return 返回结果
     */
    String updaUserInfo(String nickname, String personalizedSignature);

    /**
     * 判断用户是否有密码
     * @return 返回判断结果
     */
    String judgeUserExistPwd();

    /**
     * 展示用户信息
     * @return 返回结果
     */
    String userInfo();
}
