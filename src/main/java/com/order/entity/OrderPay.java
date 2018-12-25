package com.order.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderPay)实体类
 *
 * @author makejava
 * @since 2018-12-20 19:14:58
 */
public class OrderPay implements Serializable {
    private static final long serialVersionUID = -25412265469634123L;
    //交易订单ID
    private Integer payid;
    //订单编号
    private String paynumber;
    //订单交易金额
    private String payamount;
    //商品名称
    private String payname;
    //支付宝交易号
    private String payalipay;
    //商品描述
    private String paybody;
    //创建时间
    private Date paytime;
    
    private String pay1;
    
    private String pay2;
    
    private String pay3;


    public Integer getPayid() {
        return payid;
    }

    public void setPayid(Integer payid) {
        this.payid = payid;
    }

    public String getPaynumber() {
        return paynumber;
    }

    public void setPaynumber(String paynumber) {
        this.paynumber = paynumber;
    }

    public String getPayamount() {
        return payamount;
    }

    public void setPayamount(String payamount) {
        this.payamount = payamount;
    }

    public String getPayname() {
        return payname;
    }

    public void setPayname(String payname) {
        this.payname = payname;
    }

    public String getPayalipay() {
        return payalipay;
    }

    public void setPayalipay(String payalipay) {
        this.payalipay = payalipay;
    }

    public String getPaybody() {
        return paybody;
    }

    public void setPaybody(String paybody) {
        this.paybody = paybody;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public String getPay1() {
        return pay1;
    }

    public void setPay1(String pay1) {
        this.pay1 = pay1;
    }

    public String getPay2() {
        return pay2;
    }

    public void setPay2(String pay2) {
        this.pay2 = pay2;
    }

    public String getPay3() {
        return pay3;
    }

    public void setPay3(String pay3) {
        this.pay3 = pay3;
    }

}