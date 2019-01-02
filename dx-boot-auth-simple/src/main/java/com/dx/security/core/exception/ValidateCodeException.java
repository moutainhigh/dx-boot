package com.dx.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Description:验证码错误异常，继承spring security的认证异常
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
