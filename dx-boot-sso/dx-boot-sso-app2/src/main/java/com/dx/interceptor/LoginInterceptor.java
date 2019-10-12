package com.dx.interceptor;

import com.dx.security.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description: com.dx.interceptor
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        // 得到用户请求的URI
        String request_uri = request.getRequestURI();

        if ("/login".equals(request_uri) || "/toLogin".equals(request_uri)){
            return super.preHandle(request, response, handler);
        } else {
            User user = (User)session.getAttribute("user");
            //判断是用户是否存在
            if(user == null){
                response.sendRedirect("/toLogin");
                return false;
            }else {
                return super.preHandle(request, response, handler);
            }
        }
    }
}
