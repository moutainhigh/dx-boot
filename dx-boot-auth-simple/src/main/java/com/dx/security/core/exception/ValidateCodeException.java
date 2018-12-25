package com.dx.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * ClassName: ValidateCodeException 
 * @Description: 验证码错误异常，继承spring security的认证异常
 * @author lihaoyang
 * @date 2018年3月2日
 */
public class ValidateCodeException extends AuthenticationException {

	public ValidateCodeException(String msg) {
		super(msg);
	}

}
