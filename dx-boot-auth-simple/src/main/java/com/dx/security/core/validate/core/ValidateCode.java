package com.dx.security.core.validate.core;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Description: 短信验证码
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-23
 */
public class ValidateCode implements Serializable{

	/**
	 * 验证码
	 */
	private String code;
	/**
	 * 过期时间点
	 */
	private LocalDateTime expireTime;
	
	
	/**
	 * @param code 验证码
	 * @param expireTn 多少秒过期
	 */
	public ValidateCode(String code, int expireTn) {
		this.code = code;
		//过期时间=当前时间+过期秒数 
		this.expireTime = LocalDateTime.now().plusSeconds(expireTn);
	}

	/**
	 * @param code 验证码
	 * @param expireTime 过期时间
	 */
	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	/**
	 * 判断验证码是否过期
	 * @return  true 过期,false 没过期
	 */
	public boolean isExpired(){
		return LocalDateTime.now().isAfter(expireTime);
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
	}

}
