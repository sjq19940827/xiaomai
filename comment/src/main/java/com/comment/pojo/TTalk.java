package com.comment.pojo;


public class TTalk {

  private Integer talk_id;
  private Integer answer_id;
  private Integer user_id;
  private String talk_info;

  public Double getGrade() {
    return grade;
  }

  public void setGrade(Double grade) {
    this.grade = grade;
  }

  private Double grade;
  private Integer prase_count;
  private TUser tUser;
  private TShow tShow;

  public Integer getAnswer_id() {
    return answer_id;
  }

  public void setAnswer_id(Integer answer_id) {
    this.answer_id = answer_id;
  }

  public TUser gettUser() {
    return tUser;
  }

  public void settUser(TUser tUser) {
    this.tUser = tUser;
  }

  public TShow gettShow() {
    return tShow;
  }

  public void settShow(TShow tShow) {
    this.tShow = tShow;
  }

  public Integer getTalk_id() {
    return talk_id;
  }

  public void setTalk_id(Integer talk_id) {
    this.talk_id = talk_id;
  }

  public Integer getAnswer_idd() {
    return answer_id;
  }

  public void setAnswer_idd(Integer answer_idd) {
    this.answer_id = answer_idd;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public String getTalk_info() {
    return talk_info;
  }

  public void setTalk_info(String talk_info) {
    this.talk_info = talk_info;
  }



  public Integer getPrase_count() {
    return prase_count;
  }

  public void setPrase_count(Integer prase_count) {
    this.prase_count = prase_count;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  private String createtime;


}
