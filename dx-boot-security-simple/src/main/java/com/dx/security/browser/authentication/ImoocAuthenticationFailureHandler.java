package com.dx.security.browser.authentication;

import com.dx.security.core.properties.LoginType;
import com.dx.security.core.properties.SecurityProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登录失败后的处理
 *
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@Component("imoocAuthenticationFailureHandler")
public class ImoocAuthenticationFailureHandler

        extends SimpleUrlAuthenticationFailureHandler
        /*implements AuthenticationFailureHandler*/ {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //springmvc启动会自动注册一个ObjectMapper
    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        logger.info("登录失败");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
            //把authentication返回给响应
            //状态码500，服务器内部错误
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(exception));
        }else{
            super.onAuthenticationFailure(request, response, exception);
        }
    }

}
