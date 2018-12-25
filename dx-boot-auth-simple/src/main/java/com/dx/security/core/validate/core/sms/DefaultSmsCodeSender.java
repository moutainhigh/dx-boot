package com.dx.security.core.validate.core.sms;

/**
 * 默认的短信验证码发送类
 * ClassName: DefaultSmsCodeSender 
 * @Description: TODO
 * @author lihaoyang
 * @date 2018年3月7日
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

	/**
     * 调用发送短信
	 * @param mobile
     * @param code
	 */
	@Override
	public void send(String mobile, String code) {
		System.err.println("向手机 :"+mobile+" 发送短信验证码 :"+code);
	}

}
