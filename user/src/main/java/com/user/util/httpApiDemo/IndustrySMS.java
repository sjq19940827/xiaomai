package com.user.util.httpApiDemo;


import com.user.util.common.Config;
import com.user.util.common.HttpUtil;
import redis.clients.jedis.Jedis;

import java.net.URLEncoder;
import java.util.Random;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS {
	private static String operation = "/industrySMS/sendSMS";
	private static String accountSid = Config.ACCOUNT_SID;
	/**
	 * 产生六位数字的验证码
	 * @return
	 */
	public static String getRandomNum(){
		Random random = new Random();
		String i = "";
		while(i.length() != 6){
			i = String.valueOf(random.nextInt(1000000));
		}
		return i;
	}

	/*private static String smsContent = "【麦票网】您的验证码为" + getRandomNum() + "，请于15分钟内正确输入，如非本人操作，请忽略此短信。";
*/
	public static String smsContent(/*HttpServletRequest request*/){
		Jedis jedis = new Jedis("localhost",6379);
		/*HttpSession session=request.getSession();*/
        String authcode = getRandomNum();
		String smsContent = "【麦票网】您的验证码为" + authcode + "，请于15分钟内正确输入，如非本人操作，请忽略此短信。";
        /*session.setAttribute("authcode",authcode);*/
        jedis.set("authcode",authcode);
		/*System.out.println(session.getAttribute("authcode") + "111asd");*/
		System.out.println(jedis.get("authcode"));
		return smsContent;
	}

	/**
	 * 验证码通知短信
	 */
	public static void execute(String to/*,HttpServletRequest request*/) {
		String tmpSmsContent = null;
	    try{
			String smsContent = smsContent(/*request*/);
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}
