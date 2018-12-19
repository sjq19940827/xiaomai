package com.user.util.httpApiDemo;


import com.user.util.common.Config;
import com.user.util.common.HttpUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
			i = random.nextInt(1000000)+"";
		}
		return i;
	}
	HttpSession session;

	/*private static String smsContent = "【麦票网】您的验证码为" + getRandomNum() + "，请于15分钟内正确输入，如非本人操作，请忽略此短信。";
*/
	public static String smsContent(){
		HttpServletRequest request =
				((ServletRequestAttributes) RequestContextHolder.
						getRequestAttributes()).getRequest();
		HttpSession session=request.getSession();

		session.setAttribute("authcode",getRandomNum());
		String smsContent = "【麦票网】您的验证码为" + session.getAttribute("authcode") + "，请于15分钟内正确输入，如非本人操作，请忽略此短信。";
		return smsContent;
	}
	/**
	 * 验证码通知短信
	 */
	public static void execute(String to) {
		String tmpSmsContent = null;
	    try{
			String smsContent = smsContent();
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
