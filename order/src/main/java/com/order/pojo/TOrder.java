package com.order.pojo;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.io.Serializable;

/**
 * 订单表(TOrder)实体类
 *
 * @author makejava
 * @since 2018-12-19 14:54:07
 */
@Data
public class TOrder implements Serializable {
    private static final long serialVersionUID = -89408410138254878L;
    //订单id(主键)
    private Integer orderId;
    //订单编号
    private String orderNumber;
    //配送方式(1.为电子票,2.快递票)
    private Integer orderMode;
    //票数
    private Integer orderNum;
    //票价(演出门票单价)
    private Double orderPrice;
    //运费
    private Double transport;
    //优惠价格(使用优惠券优惠了多少钱)
    private Double discount;
    //交易状态,0:交易关闭,1:待支付,2:待出票,3:待收货,4:已完成,5:已取消,6：已退款
    private Integer status;
    //用户id(外键)
    private Integer userId;
    //演出id(外键)
    private Integer showId;
    //收货地址id(外键)
    private Integer addressId;
    //创建时间
    private String createdate;
    //发货时间
    private String deliverydate;
    //收货地址
    private String address;
    //商品名称
    private String shopName;
    //商品图片
    private String shopImg;

    private String order1;

    private String order2;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderMode() {
        return orderMode;
    }

    public void setOrderMode(Integer orderMode) {
        this.orderMode = orderMode;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getTransport() {
        return transport;
    }

    public void setTransport(Double transport) {
        this.transport = transport;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopImg() {
        return shopImg;
    }

    public void setShopImg(String shopImg) {
        this.shopImg = shopImg;
    }

    public String getOrder1() {
        return order1;
    }

    public void setOrder1(String order1) {
        this.order1 = order1;
    }

    public String getOrder2() {
        return order2;
    }

    public void setOrder2(String order2) {
        this.order2 = order2;
    }
}