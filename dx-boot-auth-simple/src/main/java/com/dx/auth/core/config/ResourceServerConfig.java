package com.dx.auth.core.config;

import com.dx.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * Description: 资源服务器设置
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2018-12-23
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

//    @Autowired
//    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                //-----------授权相关的配置（配置的需要授权认证） ---------------------
                //.authorizeRequests()
                //.antMatchers("/get/**").permitAll()
                //任何请求,都需要身份认证
                //.anyRequest().authenticated()


                .authorizeRequests()
                // /authentication/require：处理登录，securityProperties.getBrowser().getLoginPage():用户配置的登录页
                .antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                        SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE,
                        SecurityConstants.SESSION_INVALID_PAGE,
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX+"/*",
                        //swagger
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/swagger-resources/**",
                        "/swagger-ui.html/**",
                        "/v2/**"
                ).permitAll() //验证码
                .anyRequest()        //任何请求
                .authenticated()    //都需要身份认证
                .and()
                .csrf().disable() //关闭csrf防护
                //.apply(smsCodeAuthenticationSecurityConfig);//把短信验证码配置应用上
        ;
    }
}
