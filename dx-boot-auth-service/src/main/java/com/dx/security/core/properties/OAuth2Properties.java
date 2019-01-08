package com.dx.security.core.properties;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:个接口客户端，是数组，只有一个的话就不用这个了
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
public class OAuth2Properties {
	
	/**
	 * jwt签名
	 */
	private String jwtSigningKey = "imooc";
	
	private List<OAuth2ClientProperties> clients = new ArrayList<>();

}
