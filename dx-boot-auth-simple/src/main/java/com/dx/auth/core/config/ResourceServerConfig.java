package com.dx.auth.core.config;

import com.dx.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.dx.security.core.properties.SecurityConstants;
import com.dx.security.core.properties.SecurityProperties;
import com.dx.security.core.validate.code.SmsCodeFilter;
import com.dx.security.core.validate.code.ValidateCodeFilter;
import com.dx.security.core.validate.code.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    /**
     *
     */
    @Autowired
    private ValidateCodeRepository validateCodeRepository;

    /**
     * 自定义的认证失败后的处理器
     */
    @Autowired
    private AuthenticationFailureHandler imoocAuthenticationFailureHandler;

    /**
     * 配置文件
     */
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //~~~-------------> 图片验证码过滤器 <------------------
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setValidateCodeRepository(validateCodeRepository);
        //验证码过滤器中使用自己的错误处理
        validateCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        //配置的验证码过滤url
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        //~~~-------------> 短信验证码过滤器 <------------------
        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setValidateCodeRepository(validateCodeRepository);
        //验证码过滤器中使用自己的错误处理
        smsCodeFilter.setAuthenticationFailureHandler(imoocAuthenticationFailureHandler);
        //配置的验证码过滤url
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        http

                //短信验证码过滤器
                .addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
//		.apply(imoocSocialSecurityConfig)//社交登录
//		.and()
                //把验证码过滤器加载登录过滤器前边
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)


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
                        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
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
                //把短信验证码配置应用上
                .apply(smsCodeAuthenticationSecurityConfig);
        ;
    }
}
