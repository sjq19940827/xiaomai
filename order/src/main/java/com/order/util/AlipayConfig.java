package com.order.util;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092400582243";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCb2ZydiSJhsoRBATMWbFXUudtbW2lXMxCEXzqkceRd10eQ/RdgqFwN3Hwl9wXre9PMx3CEnq+xxxuUlfw8hREP8aPqdBtfFOFPdqP7PAORGUfNa2WhDFL+EmhcJo1dTBuh43IzobtSH/n1IKYjGR4CJyhWOXDrHV8jHYrboGCzPcIhF+Sccg+N2Q4CIV67JNG/+FrDC1MncQ1+sBqtIId0legGa9vVohlbmvyI0rz0vzJshu50GFNyrjXGBXAtsAR3jfYeq72SiRn2UXZsS162xCNhx8W0d84o6MmvnxNB49LTLwjm1dtMkHcQUikUpJG/SYqWFymXEcSlcbqjW8HZAgMBAAECggEBAISfDJg+LyTF/ac3dxrYu71XHyRByIVsrdyHEOcJCBUW8g6eYLte6V7eRkMkT0RRTi3PdZ9VThtRXNX3P/rcHWXc8ei8PuKNaSHuyqIrMrnRsnlKr+P5EdKlJWttXxSKhGUhoHfxY+8ByPnge6AYaqHYYonlPYLFrsS6CgTVGBTN1vV8TD8SCMv3peP9w5WpfciTQrVxFguc600KwESEJgSHjn6c5i/6uZI/lvJ+EVSIxnuSs6QG3m5sSHcyHi039kPNYNUHYxLzrnUmotvlXNX3MQAOFJIvvbs6zEEqz4RW0Qab5DFZqmUtdD4qv97HuqHqUFG38/fqMyNt0yn4MJUCgYEA++dMR6QE4jALmqBjmDYuBfJLBShZI80B6FvnlvD6xHehjyYlM/cKpsNFov1tjGP491Z3mBhscpyTJ3FH2uk4YmsJ9PvpHNn8aWnGppcQWw9u0Mr2rHnKLw0oU7v4cZnWrgVsNNRlPFmwNMd4n9H5LSX7Jr23133kj5yquMf36EcCgYEAnmJuw94SaHCWv3yykCrjEbuTu42T5UCdEBgExCstZJtrnlUELdN4M/3mKBCJ6Kn04x6S/hm0ncBd9gcF5LPAOQlFms42xKS+Rwf0J/Oi1fR/R1igTNQJRxabsJD3iuydtzFul2/ShU/xFdQhb1O4TvBFWbuEHSiFesgvwIX2NN8CgYEA9dWWtdu2AF/PE0ovqB5H7/mziQcFZ1Ds6ay3aLEoqY/ulVsut3YCaRjs3tHglUADeq5h7Ib5Xyi626VL8LHmGvZHM1Sc/VEnamCWQ4HtrlBzX0SUU2JQFHcMwhsRrRvrTM1x+mTFn44PzpJUf/RU7uDAJ+DCh4UPB7BnVAmjQIUCgYAyCcUWynUkW9W0f4/mbjY45vsgePUtq4EzkXMICuAXdebFKfTdCX9jZaauJ7N6Nx+wFXu5HaPrZtgIn2VkQMnM+znrU5UIAUhAJqojaRyb3dfMUZqrSx33QJRFbzdVw7V8J/jZjTGEfqIbFF7PzjJfdhdi5xQxJhktlktH1srXHwKBgQCVZ5asxjCdgtCJLJLVrG2W7s+Tnt9maQp3tX81gWSnDOmkk42nb7iQb+Ck3opi7nPkuRb5U0OKQXyt1CrwJeNb9+zk4QSxi4Qxg/LLqf01houZ13Fv0U/fR+8hRJkZVanEN/Idl6TCUsf6jwpxtL+b4Jn0j6ufRETgPWzBiv7wQg==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1/aiDBx7Ni7uE+M6rIeKXzW9nX8OA61OowoSB+GQeIa0GpBfnUDY/zC+4JURuOxwrOBFe9c3cod6j/fk/V/e9efvTsGO2BGnjGk3OeLNYbppo6xZ518AL3f7C5Wsk3Pj/hgHmQucmZ5cjVGnIkU2X2yEERxtEHuDhLG6wAoUgHaqLqY47ExqLOfYK0oTWkWuVyB1cIsjsm//qxUwGVi06/bbSluc/GYs7LZYGxvET++Wy2F1DsjySmTwA1++ta4YrW96gryaQQvbypFhc9vuX+xzkWyRrIj47KCQcJ8Lwyz9h3r2t95PnzHn6vcyLn8IGnBD4U67yibbqSN89QX2UQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8080/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8080/return_url";
//    public static String return_url = "https://www.baidu.com/";
    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "https://openapi.alipay.com/gateway.do";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
