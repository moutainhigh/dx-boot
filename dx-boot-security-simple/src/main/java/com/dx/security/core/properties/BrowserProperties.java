package com.dx.security.core.properties;

import lombok.Data;

/**
 * 浏览器配置项
 *
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@Data
public class BrowserProperties {

    /**
     * 配置默认登录页
     */
    private String loginPage = "demo-login.html";

    /**
     * 配置登录类型枚举
     */
    private LoginType loginType = LoginType.JSON ;

}
