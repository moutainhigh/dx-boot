package com.dx.security.core.properties;

import lombok.Data;

/**
 * 验证码配置
 * ClassName: ValidateCodeProperties 
 * @Description: 验证码配置,验证码有图片验证码、短信验证码等，所以再包一层
 * @author lihaoyang
 * @date 2018年3月2日
 */
@Data
public class ValidateCodeProperties {
	
	/**
	 * 图片验证码配置
	 */
	private ImageCodeProperties image = new ImageCodeProperties();
	
	/**
	 * 短信验证码配置
	 */
	private SmsCodeProperties sms = new SmsCodeProperties();
		
}
