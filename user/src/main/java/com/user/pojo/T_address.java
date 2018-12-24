package com.user.pojo;

public class T_address {

    private Long address_id;//主键地址id
    private Integer user_id;//外键用户id
    private String address_alias;//地址别名
    private String address_addressee;//收件人
    private String phone;//手机号
    private String tele_phone;//座机号
    private String province_id;//外键省id
    private String city_id;//外键市id
    private String area_id;//外键区id
    private String detailed;//地址详细描述
    private Integer preferred;//是否为首选地址

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAddress_alias() {
        return address_alias;
    }

    public void setAddress_alias(String address_alias) {
        this.address_alias = address_alias;
    }

    public String getAddress_addressee() {
        return address_addressee;
    }

    public void setAddress_addressee(String address_addressee) {
        this.address_addressee = address_addressee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTele_phone() {
        return tele_phone;
    }

    public void setTele_phone(String tele_phone) {
        this.tele_phone = tele_phone;
    }

    public String getProvince_id() {
        return province_id;
    }

    public void setProvince_id(String province_id) {
        this.province_id = province_id;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getDetailed() {
        return detailed;
    }

    public void setDetailed(String detailed) {
        this.detailed = detailed;
    }

    public Integer getPreferred() {
        return preferred;
    }

    public void setPreferred(Integer preferred) {
        this.preferred = preferred;
    }
}
