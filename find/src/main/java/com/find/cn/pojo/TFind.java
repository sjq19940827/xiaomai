package com.find.cn.pojo;


public class TFind {

  private Integer find_id;
  private String information;

  private String releasetime;

  private TShow tShow;
  private TUser tUser;

  public TShow gettShow() {
    return tShow;
  }

  public void settShow(TShow tShow) {
    this.tShow = tShow;
  }

  public TUser gettUser() {
    return tUser;
  }

  public void settUser(TUser tUser) {
    this.tUser = tUser;
  }

  public Integer getFind_id() {
    return find_id;
  }

  public void setFind_id(Integer find_id) {
    this.find_id = find_id;
  }

  public String getInformation() {
    return information;
  }

  public void setInformation(String information) {
    this.information = information;
  }



  public String getReleasetime() {
    return releasetime;
  }

  public void setReleasetime(String releasetime) {
    this.releasetime = releasetime;
  }
}
