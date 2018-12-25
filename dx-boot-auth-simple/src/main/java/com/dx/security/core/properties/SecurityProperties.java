package com.dx.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置项
 * ClassName: SecurityProperties 
 * @Description: 自定义配置项
 * 这个类会读取application.properties里所有以imooc.security开头的配置项
 * 
 * imooc.security.browser.loginPage = /demo-login.html
 * 其中的browser的配置会读取到BrowserProperties中去
 * 这是以点分割的，一级一级的和类的属性对应
 * @author lihaoyang
 * @date 2018年2月28日
 */
@Data
@Configuration
@ConfigurationProperties(prefix="imooc.security")
public class SecurityProperties {

	/**
	 * 浏览器相关配置
	 */
	private BrowserProperties browser = new BrowserProperties();

	/**
	 * 验证码相关配置
	 */
	private ValidateCodeProperties code = new ValidateCodeProperties();

}
