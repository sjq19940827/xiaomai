package com.order.pay;


import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.order.util.AlipayConfig;
import com.order.util.RequestParams;

import javax.annotation.Resource;
import java.util.Map;


public class Return_url {
    @Resource

    public String return_url(Map<String,String[]> requestParams,String out_trade_no,String trade_no,String total_amount){
        //获取支付宝GET过来反馈信息
        Map<String,String> params = RequestParams.requestParams(requestParams);
        boolean signVerified = false;
        //调用SDK验证签名
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
//        System.out.println("trade_no:" + trade_no);
//        System.out.println("out_trade_no:" + out_trade_no);
//        System.out.println("total_amount:" + total_amount);

        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
     /*
           //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

*/
            return ("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
        }else {
//            return ("验签失败");
            return ("trade_no:"+trade_no+"<br/>out_trade_no:"+out_trade_no+"<br/>total_amount:"+total_amount);
        }

        //——请在这里编写您的程序（以上代码仅作参考）——
    }
}
