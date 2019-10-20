package com.dx.controller;

import com.dx.annotation.PassToken;
import com.dx.annotation.UserLoginToken;
import com.dx.bean.User;
import com.dx.service.TokenService;
import com.dx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/10/17
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    //登录
    @RequestMapping("/login")
    public Object login(User user) {
        Map<String, Object> result = new HashMap<>();


        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            result.put("message", "登录失败,用户不存在");
            return result;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                result.put("message", "登录失败,密码错误");
                return result;
            } else {
                String token = tokenService.getToken(userForBase);
                result.put("token", token);
                result.put("user", userForBase);
                return result;
            }
        }
    }

    @UserLoginToken
    @RequestMapping("/getMessage")
    public String getMessage() {
        return "你已通过验证";
    }

    @RequestMapping("/getMessage2")
    public String getMessage2() {
        return "你已通过验证2";
    }


    @PassToken
    @RequestMapping("/getMessage3")
    public String getMessage3() {
        return "你已通过验证3";
    }

}
