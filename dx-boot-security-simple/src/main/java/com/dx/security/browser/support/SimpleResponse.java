package com.dx.security.browser.support;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@Slf4j
public class SimpleResponse {

    private String message;

    public SimpleResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static Logger getLog() {
        return log;
    }
}
