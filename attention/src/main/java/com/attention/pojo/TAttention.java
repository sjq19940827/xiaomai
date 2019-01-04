package com.attention.pojo;

import java.io.Serializable;

/**
 * (TAttention)实体类
 *
 * @author makejava
 * @since 2019-01-04 10:56:24
 */
public class TAttention implements Serializable {
    private static final long serialVersionUID = 148028915236862024L;
    //关注ID
    private Integer attid;
    //关注者的ID
    private Integer attuser;
    //关注的商品ID
    private Long attshow;
    //关注标记：0.关注 1.取消关注 2.过期
    private Integer attmark;


    public Integer getAttid() {
        return attid;
    }

    public void setAttid(Integer attid) {
        this.attid = attid;
    }

    public Integer getAttuser() {
        return attuser;
    }

    public void setAttuser(Integer attuser) {
        this.attuser = attuser;
    }

    public Long getAttshow() {
        return attshow;
    }

    public void setAttshow(Long attshow) {
        this.attshow = attshow;
    }

    public Integer getAttmark() {
        return attmark;
    }

    public void setAttmark(Integer attmark) {
        this.attmark = attmark;
    }

}