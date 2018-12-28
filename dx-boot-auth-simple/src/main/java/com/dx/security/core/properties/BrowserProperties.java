package com.dx.security.core.properties;

import lombok.Data;

/**
 * 浏览器配置项
 * ClassName: BrowserProperties 
 * @Description: 浏览器配置项
 * @author lihaoyang
 * @date 2018年2月28日
 */
@Data
public class BrowserProperties {

	/**
	 * 用户未配置默认登录页
	 */
	private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE; 

	/**
	 * 登录类型，返回json或还是重定向
	 */
	private LoginType loginType = LoginType.JSON ;

	/**
	 * 记住我秒数配置
	 */
	private int rememberMeSeconds = 3600;

	/**
	 * session的相关信息
	 */
	private SessionProperties session = new SessionProperties();
	
	

	
	
}
