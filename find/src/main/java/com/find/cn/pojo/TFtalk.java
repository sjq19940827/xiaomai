package com.find.cn.pojo;


public class TFtalk {

  private Integer fid;
  private TFind tFind;
  private TUser tUser;
  private Integer findid;
  private Integer userid;

  public Integer getFindid() {
    return findid;
  }

  public void setFindid(Integer findid) {
    this.findid = findid;
  }

  public Integer getUserid() {
    return userid;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public TFind gettFind() {
    return tFind;
  }

  public void settFind(TFind tFind) {
    this.tFind = tFind;
  }

  public TUser gettUser() {
    return tUser;
  }

  public void settUser(TUser tUser) {
    this.tUser = tUser;
  }

  private String talkinfo;
  private String createtime;
  private Integer replyuserid;
  private Integer prasecount;

  public Integer getFid() {
    return fid;
  }

  public void setFid(Integer fid) {
    this.fid = fid;
  }



  public String getTalkinfo() {
    return talkinfo;
  }

  public void setTalkinfo(String talkinfo) {
    this.talkinfo = talkinfo;
  }

  public String getCreatetime() {
    return createtime;
  }

  public void setCreatetime(String createtime) {
    this.createtime = createtime;
  }

  public Integer getReplyuserid() {
    return replyuserid;
  }

  public void setReplyuserid(Integer replyuserid) {
    this.replyuserid = replyuserid;
  }

  public Integer getPrasecount() {
    return prasecount;
  }

  public void setPrasecount(Integer prasecount) {
    this.prasecount = prasecount;
  }
}
