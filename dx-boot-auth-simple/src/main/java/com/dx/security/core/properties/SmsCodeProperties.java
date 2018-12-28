package com.dx.security.core.properties;

import lombok.Data;

/**
 * 短信验证码配置类
 * ClassName: ImageCodeProperties 
 * @Description: 图片验证码配置类
 * @author lihaoyang
 * @date 2018年3月2日
 */
@Data
public class SmsCodeProperties {

	/**
	 * 验证码字符个数
	 */
	private int length = 4;

	/**
	 * 过期时间
	 */
	private int expireIn = 60;

	/**
	 * 拦截的url
	 */
	private String url;

}
