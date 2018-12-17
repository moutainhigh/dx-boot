package com.dx.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码错误异常，继承spring security的认证异常
 *
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
