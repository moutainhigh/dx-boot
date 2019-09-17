package com.dx.filter;

import com.dx.bean.User;
import com.dx.servcie.UserService;
import com.dx.util.AppData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginFilter implements Filter {

    @Autowired
    private AppData appData;

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        // 得到用户请求的URI
        String request_uri = req.getRequestURI();

        if ("/login".equals(request_uri)){
            chain.doFilter(request,response);
        }else if ("/toLogin".equals(request_uri)){
            chain.doFilter(request,response);
        } else {
            User user = (User)session.getAttribute("user");

            //判断是用户是否存在
            if(user == null){
                resp.sendRedirect("/toLogin");
            }else {
                chain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {
        log.info("destroy");
    }
}
