package com.discount.pojo;


import java.util.Date;

public class TDiscount {

  private Integer discount_id;
  private Integer reduce_id;
  private Integer user_id;
  private Integer discount_mark;
  private Date create;
  private Date exitss;
  private TReduce d;

  public TReduce getD() {
    return d;
  }

  public void setD(TReduce d) {
    this.d = d;
  }

  public Integer getDiscount_id() {
    return discount_id;
  }

  public void setDiscount_id(Integer discount_id) {
    this.discount_id = discount_id;
  }

  public Integer getReduce_id() {
    return reduce_id;
  }

  public void setReduce_id(Integer reduce_id) {
    this.reduce_id = reduce_id;
  }

  public Integer getUser_id() {
    return user_id;
  }

  public void setUser_id(Integer user_id) {
    this.user_id = user_id;
  }

  public Integer getDiscount_mark() {
    return discount_mark;
  }

  public void setDiscount_mark(Integer discount_mark) {
    this.discount_mark = discount_mark;
  }

  public Date getCreate() {
    return create;
  }

  public void setCreate(Date create) {
    this.create = create;
  }

  public Date getExitss() {
    return exitss;
  }

  public void setExitss(Date exitss) {
    this.exitss = exitss;
  }
}
