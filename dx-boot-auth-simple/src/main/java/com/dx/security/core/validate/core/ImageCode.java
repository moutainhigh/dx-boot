package com.dx.security.core.validate.core;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * Description: 图片验证码
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-23
 */
public class ImageCode extends ValidateCode{

	/**
	 * 验证码图片
	 */
	private BufferedImage image;
	
	/**
	 * @param image 验证码图片流
	 * @param code 验证码
	 * @param expireTn 多少秒过期
	 */
	public ImageCode(BufferedImage image, String code, int expireTn) {
		super(code,expireTn);
		this.image = image;
	}

	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
		super(code,expireTime);
		this.image = image;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

}
