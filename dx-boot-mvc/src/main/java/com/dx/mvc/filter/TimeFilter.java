package com.dx.mvc.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Description: com.dx.filter
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Slf4j
@Component
@Order(1)
public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("TimeFilter init  1");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        // 得到用户请求的URI
        String request_uri = req.getRequestURI();

        log.info("TimeFilter time   1: " + System.currentTimeMillis());
        log.info(request_uri);
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info("TimeFilter destroy  1");
    }
}
