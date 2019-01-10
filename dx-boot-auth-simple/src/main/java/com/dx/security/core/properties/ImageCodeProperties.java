package com.dx.security.core.properties;

import lombok.Data;

/**
 * Description:图片验证码配置类
 * 图片验证码配置类，也可以继承SMSCodeProperties,省略点代码，随你的便
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
public class ImageCodeProperties {

	/**
	 * 图片宽
	 */
	private int width = 67;

	/**
	 * 图片高
	 */
	private int height = 23;

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
