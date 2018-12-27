package com.order.controller;

import com.order.dao.TOrderDao;
import com.order.pay.*;
import com.order.pojo.OrderPay;
import com.order.service.OrderPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Map;

import static com.order.util.DateGenerate.getStringDate;

@Controller
@Api(value="AlipayController",description="支付宝支付接口测试")
public class AlipayController {
    @Resource
    private OrderPayService orderPayService;
    @Resource
    private TOrderDao tOrderDao;

        @ResponseBody
        @RequestMapping(value = "close",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "关闭交易", httpMethod ="GET", response = String.class, notes ="关")
        public String close(String WIDTCout_trade_no, String WIDTCtrade_no) {
            Close c = new Close();
            String s = c.close(WIDTCout_trade_no, WIDTCtrade_no);
            return s;
        }

    /**
     *
     * @param WIDout_trade_no   订单号
     * @param WIDtotal_amount   交易金额
     * @param WIDsubject    商品名称
     * @param WIDbody       商品描述
     * @param request
     * @return
     */
        @ResponseBody
        @RequestMapping(value = "pay",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "模拟支付", httpMethod ="GET", response = String.class, notes ="模拟支付")
        public String pay(String WIDout_trade_no, String WIDtotal_amount, String WIDsubject, String WIDbody, HttpServletRequest
        request) {
            Pay p = new Pay();
            String result = p.pay(WIDout_trade_no,WIDtotal_amount,WIDsubject,WIDbody);
            return result;
        }
        @ResponseBody
        @RequestMapping(value = "notify_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "通知网址", httpMethod ="GET", response = String.class, notes ="通知网址")
        public String notify_url(String out_trade_no, String trade_no, String trade_status, HttpServletRequest request) {
            Map<String, String[]> requestParams = request.getParameterMap();
            Notify_url n = new Notify_url();
            String result = n.notify_url(requestParams, out_trade_no, trade_no, trade_status);
            return result;
        }
        @ResponseBody
        @RequestMapping(value = "query",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "询问", httpMethod ="GET", response = String.class, notes ="询问")
        public String Query(String WIDTQout_trade_no, String WIDTQtrade_no) {
            Query q = new Query();
            String s = q.query(WIDTQout_trade_no, WIDTQtrade_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "refund",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "退款", httpMethod ="POST", response = String.class, notes ="退款")
        public String refund(String WIDTRout_trade_no, String WIDTRtrade_no, String WIDTRrefund_amount, String WIDTRrefund_reason, String WIDTRout_request_no) throws UnsupportedEncodingException {
            Refund r = new Refund();
            String s = r.refund(WIDTRout_trade_no, WIDTRtrade_no,WIDTRrefund_amount,WIDTRrefund_reason,WIDTRout_request_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "refundQuery",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "退款查询", httpMethod ="GET", response = String.class, notes ="退款查询")
        public String refundQuery(String WIDRQout_trade_no, String WIDRQtrade_no, String WIDRQout_request_no) {
            RefundQuery r = new RefundQuery();
            String s = r.refundQuery(WIDRQout_trade_no,WIDRQtrade_no,WIDRQout_request_no);
            return s;
        }

        @ResponseBody
        @RequestMapping(value = "return_url",method = RequestMethod.GET,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "创建订单明细", httpMethod ="GET", response = String.class, notes ="创建订单明细")
        public String alipayReturn_url(String out_trade_no, String trade_no, String total_amount,HttpServletRequest request) {
            Map<String, String[]> requestParams = request.getParameterMap();
            Return_url r = new Return_url();
            String s = r.return_url(requestParams,out_trade_no,trade_no,total_amount);
            OrderPay orderPay = new OrderPay();
            orderPay.setPaynumber(out_trade_no);
            orderPay.setPayalipay(trade_no);
            orderPay.setPayamount(total_amount);
            Timestamp timestamp = Timestamp.valueOf(getStringDate());
            orderPay.setPaytime(timestamp);
            orderPay.setPaystate("已支付");
            //查询订单编号是否存在
            int selectByOrderNumber = tOrderDao.selectByOrderNumber(out_trade_no);
            if(selectByOrderNumber != 0){
                int orderPayInfo = orderPayService.insertByOrderPayInfo(orderPay);
                if(orderPayInfo != 0){
                    int updateByOrderStatePay = tOrderDao.updateByOrderStatePay(out_trade_no,getStringDate());
                    if(updateByOrderStatePay != 0){
                        return "订单数据存储成功";
                    }else {
                        return "订单状态更改失败";
                    }
                }else {
                    return "订单信息有误！";
                }
            }else {
                return "订单编号不存在，请确认后再支付";
            }
        }

}
