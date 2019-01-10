package com.dx.security.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


/**
 * Description: 核心自定义配置项
 * 这个类会读取application.properties里所有以imooc.security开头的配置项
 * imooc.security.browser.loginPage = /demo-login.html
 * 其中的browser的配置会读取到BrowserProperties中去
 * 这是以点分割的，一级一级的和类的属性对应
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "imooc.security")
public class SecurityProperties {

    /**
     * 浏览器相关配置
     */
    private BrowserProperties browser = new BrowserProperties();

    /**
     * 验证码相关配置
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();

    /**
     * oauth2客户端配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

}
