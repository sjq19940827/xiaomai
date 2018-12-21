package com.order.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 * (OrderPay)实体类
 *
 * @author makejava
 * @since 2018-12-20 19:59:54
 */
public class OrderPay implements Serializable {
    private static final long serialVersionUID = 479673209119824171L;
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
    private Timestamp paytime;
    //支付状态
    private String paystate;
    
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

    public Timestamp getPaytime() {
        return paytime;
    }

    public void setPaytime(Timestamp paytime) {
        this.paytime = paytime;
    }

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
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