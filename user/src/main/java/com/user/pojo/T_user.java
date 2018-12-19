package com.user.pojo;

/**
 * 用户表
 */
public class T_user {

    private Integer id; //主键
    private String userName; // 用户真实姓名
    private String nickname; //用户昵称
    private String password; //密码
    private Integer sex; //性别
    private String identityCode; // 身份证号
    private String userdate; // 出生日期
    private String loginName; // 手机登录号
    private Integer usertype; // 用户类型
    private String imageName; // 图片文件名
    private Double balance; //余额
    private String latelyLogin; // 最近一次登录时间
    private String login_phone; //手机登录

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserdate() {
        return userdate;
    }

    public void setUserdate(String userdate) {
        this.userdate = userdate;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getLatelyLogin() {
        return latelyLogin;
    }

    public void setLatelyLogin(String latelyLogin) {
        this.latelyLogin = latelyLogin;
    }

    public String getLogin_phone() {
        return login_phone;
    }

    public void setLogin_phone(String login_phone) {
        this.login_phone = login_phone;
    }
}
