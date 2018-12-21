package com.comment.pojo;


public class TReplytalk {

  private Integer reply_id;
  private Integer replyuser_id;
  private Integer talk_id;
  private String reply_info;
  private Integer prase_count;
  private String createtime;
  private TUser tUser;
  private TTalk tTalk;

  public TUser gettUser() {
    return tUser;
  }

  public void settUser(TUser tUser) {
    this.tUser = tUser;
  }

  public TTalk gettTalk() {
    return tTalk;
  }

  public void settTalk(TTalk tTalk) {
    this.tTalk = tTalk;
  }

  public Integer getReply_id() {
    return reply_id;
  }

  public void setReply_id(Integer reply_id) {
    this.reply_id = reply_id;
  }

  public Integer getReplyuser_id() {
    return replyuser_id;
  }

  public void setReplyuser_id(Integer replyuser_id) {
    this.replyuser_id = replyuser_id;
  }

  public Integer getTalk_id() {
    return talk_id;
  }

  public void setTalk_id(Integer talk_id) {
    this.talk_id = talk_id;
  }

  public String getReply_info() {
    return reply_info;
  }

  public void setReply_info(String reply_info) {
    this.reply_info = reply_info;
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
}
