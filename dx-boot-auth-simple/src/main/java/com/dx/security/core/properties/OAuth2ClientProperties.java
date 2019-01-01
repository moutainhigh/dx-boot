package com.dx.security.core.properties;

import lombok.Data;

/**
 * 接口授权客户端配置 ClassName: OAuth2ClientProperties
 * 
 * @Description: 接口授权客户端配置
 * @author lihaoyang
 * @date 2018年3月15日
 */
@Data
public class OAuth2ClientProperties {

	private String clientId;

	private String clientSecret;

	/**
	 * 没配置就用默认值
	 */
	private int accessTokenValiditySeconds = 3600;
	
	// xxxxx在这里扩展配置


}
