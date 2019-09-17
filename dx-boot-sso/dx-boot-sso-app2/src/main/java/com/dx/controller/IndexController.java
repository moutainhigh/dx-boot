package com.dx.controller;

import com.dx.bean.User;
import com.dx.service.UserService;
import com.dx.util.AppData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private AppData data;

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpSession session){

        User tempUser = null;
        if (user.getUsername()!=null){
            tempUser = userService.login(user.getUsername(), user.getPassword());
        }

        if (tempUser == null) {
            return "登录失败";
        }else {
            //如果登录过就进行下线操作
            User user1 = (User)session.getAttribute("user");
            if (user1 != null){
                userService.unLogin(user1.getUsername());
            }
            session.setAttribute("user",tempUser);
            return "登录成功";
        }
    }

    @ResponseBody
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "请进行登录操作";
    }

    @ResponseBody
    @RequestMapping("/get")
    public String get(HttpSession session){
        User user = (User) session.getAttribute("user");
        return "user: " + user;
    }

    @ResponseBody
    @RequestMapping("/unLogin")
    public String unLogin(HttpSession session){
        User user = (User)session.getAttribute("user");
        session.removeAttribute("user");
        userService.unLogin(user.getUsername());
        return "unLogin";
    }

}
