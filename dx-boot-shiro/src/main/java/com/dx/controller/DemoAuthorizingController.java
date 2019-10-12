package com.dx.security.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/26
 */
@Controller
public class DemoAuthorizingController {

    /**
     * 需要登录访问的接口
     * @param test
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/get")
    @ResponseBody
    public String get(String test){

        return "get ok";
    }


    /**
     * 普通不需要登录的界面
     * @return
     */
    @ResponseBody
    @GetMapping("/html/get")
    public String html(){

        return "普通不需要登录的页面";
    }

    /**
     * 普通需要登录的界面
     * @return
     */
    @RequiresAuthentication
    @ResponseBody
    @GetMapping("/html/get2")
    public String htmlget2(){

        return "需要登录的页面！！";
    }


    /**
     * 需要验证权限登录
     * @return
     */
    @RequiresPermissions("")
    @ResponseBody
    @GetMapping("/getData")
    public String authenrazation(){

        return "403 页面";
    }


    /**
     * 跳转登录页面
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/toLogin")
    public String toLogin(){

        return "login 页面";
    }


    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    @ResponseBody
    @GetMapping("/login")
    public String login(String username,String password){

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        subject.login(token);

        return "登录成功";
    }

    /**
     * 403接口
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/403")
    public String noAuthentication(){

        return "403 页面";
    }


}
