package com.dx.security.core.properties;

import lombok.Data;

/**
 * 多个接口客户端，是数组，只有一个的话就不用这个了
 * ClassName: OAuth2Properties 
 * @Description: TODO
 * @author lihaoyang
 * @date 2018年3月15日
 */
@Data
public class OAuth2Properties {
	
	/**
	 * jwt签名
	 */
	private String jwtSigningKey = "imooc";
	
	private OAuth2ClientProperties[] clients = {};

}
