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
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCRPtcHiaU4rSgzW/aR16EP8Xw/cY+ilBRL3FmZvmVV4cQqN2izIrmeTsJtP25vLBHLJGEDVAe7ZqVXtbp+dkekRlmfdcISwUQO3K0YhGLwCj7cEHhrBFHCrdXb56VxC4oviUXV03LtNSVEKA0aZQF7QlDYV5xMpqDadOb8/nRozNl0JVJ0CBwJ0Hzkr4VHKgVW3arnhQCbwy+0iKcP5aBR2q0B9joUvebl165c/K+klSOlTO1iNNxgZcFrX6wcZ2ZrX2b9976iwZ/W081K+V/sB+jxttSqRXmtAf6rAzw6jaGSGSsSCrt22+l9RHl7P+OBALBquKsa7wCxnEFSQm9HAgMBAAECggEAWto14w8kfDlD5ixmJX/9zV0+XOkJ8aYys+kXWuYPuRLJg6a5JSRZez7Eu1VsHLoyPyF4VX6gf4aLcjvIdgZCde1Tbj1YsiaWDb3XwHg+8utVuo3K5RYEloPqO+3APN/9BhMVzdTAFMSjlOiAmbwImzM2Ir1alU+9Wii5vBLmeg6FuLPsLiaWSic00XZ8KcCMd+hR5vi6+1PidVDdMoa3v7TX7pNpQ3SmW65HCXz8edjpfaWmDn4Mk+N3eFlGN0tSFOXnv15bzTsfEWW52/IblC2oWjWVnokkq53Wsq8iZawbXLZj8rqbtLNjbPR/NPf7ibAdExl51hlwoggmMCzEYQKBgQDcA43LE9vbsFwF+wrfIG2u2DtXpIBmA7AmPQTnJO4PbRNFtKM9IxogJTpNlVzeuYkLlZZd4hNeINo807rwwQQITMqDKBHJBTZeHEdenif19O4inar0fbYytKoiBdobRnQvDBBYpwUv8Km+w3ynAFDgcD4GcPDGUggxRiZ3ZakM7wKBgQCpAJMaGnnVjvazSIsyjut1uneMp/SK4bhmq2NpKy1B2Bkmgmv0sgFv8ognV2egHa8c4P6qQJ7R53fDapa3CDKWSLJcijXfj6/sqJiTrxQvvJ3TBMM5fJamrGP8w+YQrKsFIl5lk489kXee9u4m4EEtmEAHtx7HOXZy7MKpPKBzKQKBgH6TbNgQrMRPSiIGs9J6jZ+xtzJM6bHHHWhiYpe4n10wm43WxrM9pqInyMspyyw4Aagwfzmz/wCAVg34oewwn2lHBJtASjskTIsIKec9hi/yoa44l0nhqRiy5857H2fhuKX4gs7+B/X0tzOQs/5AKEd3S7fY8iymtR/kA+1dB0zxAoGAN/tNvw7YHsrNo5O7MFMxYf0Tjs8v7TVaDQBm3LaFtlLr+dqoAhVY7olLWqTUWbCbihhpo2HmeiePf3b2V8jqYOfR1V+e+uAw6Vbru7f6GtoC+ZyRQqCnkqx2LouB0TIxMHEzDbi0cTOXiVvIha4xSPYu959MHbhGKUmOLds8VwkCgYBsldnh90yaydLFMvW5jrzz4jSD58avHOOHpfpVdDQ0YriYtAELZeA/3O14rpZbUAROCyZ58vB4zLqgymMmiyf+j0wyGndXggLJd7a0HRC3d0zJiYFSrWxZFP2jdiLJ4ge5z3CPCpxA99nFCA9wkicPuSPrpY3ayOB6iWxxvRl+JQ==";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkT7XB4mlOK0oM1v2kdehD/F8P3GPopQUS9xZmb5lVeHEKjdosyK5nk7CbT9ubywRyyRhA1QHu2alV7W6fnZHpEZZn3XCEsFEDtytGIRi8Ao+3BB4awRRwq3V2+elcQuKL4lF1dNy7TUlRCgNGmUBe0JQ2FecTKag2nTm/P50aMzZdCVSdAgcCdB85K+FRyoFVt2q54UAm8MvtIinD+WgUdqtAfY6FL3m5deuXPyvpJUjpUztYjTcYGXBa1+sHGdma19m/fe+osGf1tPNSvlf7Afo8bbUqkV5rQH+qwM8Oo2hkhkrEgq7dtvpfUR5ez/jgQCwarirGu8AsZxBUkJvRwIDAQAB";

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
