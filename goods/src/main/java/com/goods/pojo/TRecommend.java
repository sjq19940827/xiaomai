package com.goods.pojo;

import java.io.Serializable;

/**
 * (TRecommend)实体类
 *
 * @author makejava
 * @since 2019-01-16 09:10:27
 */
public class TRecommend implements Serializable {
    private static final long serialVersionUID = -26426600269122294L;
    //主键
    private Integer rId;
    //大标题
    private String rMain;
    //小标题
    private String rMinor;
    //特点声明
    private String rPoint;
    //图片
    private String rImg;
    //对应商品ID
    private Long showid;
    //城市
    private String city;


    public Integer getRId() {
        return rId;
    }

    public void setRId(Integer rId) {
        this.rId = rId;
    }

    public String getRMain() {
        return rMain;
    }

    public void setRMain(String rMain) {
        this.rMain = rMain;
    }

    public String getRMinor() {
        return rMinor;
    }

    public void setRMinor(String rMinor) {
        this.rMinor = rMinor;
    }

    public String getRPoint() {
        return rPoint;
    }

    public void setRPoint(String rPoint) {
        this.rPoint = rPoint;
    }

    public String getRImg() {
        return rImg;
    }

    public void setRImg(String rImg) {
        this.rImg = rImg;
    }

    public Long getShowid() {
        return showid;
    }

    public void setShowid(Long showid) {
        this.showid = showid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}