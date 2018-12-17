package com.dx.security.browser;

import com.dx.security.browser.support.SimpleResponse;
import com.dx.security.core.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理用户认证Controller，浏览器和app的请求做不同的处理
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@RestController
public class BrowserSecurityController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //缓存的请求，SpringSecurity通过HttpSessionRequestCache把请求信息缓存到session里
    private RequestCache requestCache = new HttpSessionRequestCache();
    //跳转的工具
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    /**
     * 当需要身份认证时，跳转到这里处理
     * @Description: TODO
     * @param @param request
     * @param @param response
     * @param @return
     * @return String
     * @throws Exception
     * @throws
     * @author lihaoyang
     * @date 2018年2月28日
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code=HttpStatus.UNAUTHORIZED)//返回状态码401 未授权
    public SimpleResponse requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //拿出缓存的请求 引发跳转的请求
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if(savedRequest != null){
            //拿到引发请求的url
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info("引发跳转的url："+targetUrl);
            if(StringUtils.endsWithIgnoreCase(targetUrl, ".html")){//请求是否以.html结尾
                //要跳转的页面，此处应该做成可配置的页面
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }
        return new SimpleResponse("访问的服务需要身份认证，请引导用户到登录页");
    }

}