package com.order.pojo;

import java.util.Date;
import java.io.Serializable;

/**
 * (OrderPay)实体类
 *
 * @author makejava
 * @since 2018-12-27 17:34:29
 */
public class OrderPay implements Serializable {
    private static final long serialVersionUID = 174885160179275861L;
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
    //支付状态
    private String paystate;
    //创建时间
    private String paytime;
    //退款原因
    private String refundcause;
    //退款时间
    private String refundtime;
    //退款说明
    private String refundment;

    private String pay1;

    private String pay2;

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

    public String getPaystate() {
        return paystate;
    }

    public void setPaystate(String paystate) {
        this.paystate = paystate;
    }

    public String getPaytime() {
        return paytime;
    }

    public void setPaytime(String paytime) {
        this.paytime = paytime;
    }

    public String getRefundcause() {
        return refundcause;
    }

    public void setRefundcause(String refundcause) {
        this.refundcause = refundcause;
    }

    public String getRefundtime() {
        return refundtime;
    }

    public void setRefundtime(String refundtime) {
        this.refundtime = refundtime;
    }

    public String getRefundment() {
        return refundment;
    }

    public void setRefundment(String refundment) {
        this.refundment = refundment;
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
}