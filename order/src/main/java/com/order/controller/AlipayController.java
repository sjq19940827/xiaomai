package com.order.controller;

import com.alibaba.fastjson.JSON;
import com.order.dao.OrderPayDao;
import com.order.dao.TOrderDao;
import com.order.pay.*;
import com.order.pojo.OrderPay;
import com.order.pojo.TOrder;
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
import java.util.Map;

import static com.order.util.DateGenerate.getStringDate;

@Controller
@Api(value="AlipayController",description="支付宝支付接口测试")
public class AlipayController {
    @Resource
    private OrderPayService orderPayService;
    @Resource
    private TOrderDao tOrderDao;
    @Resource
    private OrderPayDao orderPayDao;

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

        /**
         *
         * @param WIDTRout_trade_no   商户订单号，商户网站订单系统中唯一订单号
         * @param WIDTRtrade_no       支付宝交易号
         * @param WIDTRrefund_amount  需要退款的金额，该金额不能大于订单金额，必填
         * @param WIDTRrefund_reason  退款的原因说明
         * @param WIDTRout_request_no 标识一次退款请求，同一笔交易多次退款需要保证唯一，如需部分退款，则此参数必传
         * @return
         * @throws UnsupportedEncodingException
         */
        @ResponseBody
        @RequestMapping(value = "refund",method = RequestMethod.POST,produces = "text/html; charset=utf-8")
        @ApiOperation(value = "退款", httpMethod ="POST", response = String.class, notes ="退款")
        public String refund(String WIDTRout_trade_no, String WIDTRtrade_no, String WIDTRrefund_amount, String WIDTRrefund_reason, String WIDTRout_request_no){
            Refund r = new Refund();
            String s = r.refund(WIDTRout_trade_no, WIDTRtrade_no,WIDTRrefund_amount,WIDTRrefund_reason,WIDTRout_request_no);
            if("10000".equals(s)){
                //根据订单编号查询订单交易明细表的该编号ID
                Integer id = orderPayDao.selectPayNumberByPayID(WIDTRout_trade_no);
                //根据ID查询订单明细信息
                OrderPay orderPay = orderPayDao.queryById(id);
                //根据订单编号查询订单表的信息
                Integer ID = tOrderDao.selectOrderIDByorderNumber(WIDTRout_trade_no);
                TOrder tOrder = tOrderDao.queryById(ID);
                OrderPay newOrderPay = new OrderPay();
                newOrderPay.setPayid(id);
                newOrderPay.setPayname(tOrder.getShopName());   //商品名称
                newOrderPay.setRefundtime(getStringDate());     //退款时间
                newOrderPay.setRefundcause(WIDTRrefund_reason); //退款原因
                newOrderPay.setRefundment("全额退款：" + WIDTRrefund_amount);
                newOrderPay.setPaystate("已退款");
                int update = orderPayDao.update(newOrderPay);
                if(update != 0){
                    tOrderDao.updaterefund(WIDTRout_trade_no);
                }
                return "退款成功";
            }else if("40004".equals(s) ){
                return "退款出问题了，请联系福根女士，谢谢！";
            }else if("10003".equals(s)){
                return "付款仍在处理中。商家需要轮询付款结果。";
            }else if("20000".equals(s)){
                return "处理呼叫时出现未知错误或系统错误。商家需要查询订单状态或取消。";
            }else {
                return "退款失败";
            }
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
            Integer insert = orderPayService.insert(out_trade_no, trade_no, total_amount);
            if(insert != 0 && insert != null){
                return "订单支付成功，订单号为：" + out_trade_no;
            }else {
                return "订单支付失败。";
            }
        }

}
