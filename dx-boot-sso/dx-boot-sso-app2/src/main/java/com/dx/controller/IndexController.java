package com.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Description: com.dx
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Controller
public class IndexController {


    @ResponseBody
    @RequestMapping("/login")
    public String login(String user, HttpServletRequest request){
        if (!StringUtils.isEmpty(user) && "admin".equals(user)){
            request.getSession().setAttribute("user","admin");
            return "登录成功";
        }else {
            return "登录失败";
        }
    }

    @ResponseBody
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "请进行登录操作";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String get(){
        return "user:is admin";
    }

    @ResponseBody
    @RequestMapping("/unLogin")
    public String unLogin(HttpSession session){
        session.removeAttribute("user");
        return "unLogin";
    }

}
