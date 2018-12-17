package com.dx.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 自定义配置项
 * 这个类会读取application.properties里所有以imooc.security开头的配置项
 *
 * imooc.security.browser.loginPage = /demo-login.html
 * 其中的browser的配置会读取到BrowserProperties中去
 * 这是以点分割的，一级一级的和类的属性对应
 *
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@ConfigurationProperties(prefix="imooc.security")
@Data
public class SecurityProperties {

    /**
     * 浏览器配置项
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码配置项
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

}
