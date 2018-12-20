package com.discount.pojo;
import javax.xml.crypto.Data;

//优惠券
public class T_Reduce {

  private Integer reduce_Id;//优惠券id
  private String reduce_Number;//优惠劵号码
  private String reduce_Tot;//优惠券满减的金额
  private String sub;//优惠券个数
  private Data createDate;//有效日期开始时间
  private Data exitDate;//有效日期结束时间


  public Integer getReduceId() {
    return reduce_Id;
  }

  public void setReduceId(Integer reduceId) {
    this.reduce_Id = reduceId;
  }


  public String getReduceNumber() {
    return reduce_Number;
  }

  public void setReduceNumber(String reduceNumber) {
    this.reduce_Number = reduceNumber;
  }


  public String getReduceTot() {
    return reduce_Tot;
  }

  public void setReduceTot(String reduceTot) {
    this.reduce_Tot = reduceTot;
  }


  public String getSub() {
    return sub;
  }

  public void setSub(String sub) {
    this.sub = sub;
  }


  public Data getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Data createDate) {
    this.createDate = createDate;
  }


  public Data getExitDate() {
    return exitDate;
  }

  public void setExitDate(Data exitDate) {
    this.exitDate = exitDate;
  }

}
