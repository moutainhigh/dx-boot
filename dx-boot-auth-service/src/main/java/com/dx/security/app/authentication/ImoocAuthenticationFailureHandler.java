package com.dx.security.app.authentication;

import com.dx.security.core.properties.LoginType;
import com.dx.security.core.properties.SecurityProperties;
import com.dx.security.core.support.SimpleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
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
 * ClassName: ImoocAuthenticationFailureHandler
 *
 * @author lihaoyang
 * @Description: 登录失败后的处理
 * @date 2018年3月1日
 */
@Component("imoocAuthenticationFailureHandler")
public class ImoocAuthenticationFailureHandler
        extends SimpleUrlAuthenticationFailureHandler{

    /**
     * springmvc启动会自动注册一个ObjectMapper
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {

        logger.info("登录失败");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            //把authentication返回给响应
            //状态码500，服务器内部错误
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType("application/json;charset=UTF-8");
            //值返回异常信息
            response.getWriter().write(objectMapper.writeValueAsString(new SimpleResponse(exception.getMessage())));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }
    }
}
