package com.dx.auth.controller;

import com.dx.auth.entity.MyUserDetails;
import com.dx.auth.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-7
 */
@RestController
public class UserController {

    @Autowired
    private TokenStore tokenStore;

    @PostMapping("/bar")
    public String bar(/*@RequestHeader("Authorization")*/ String auth) {

        MyUserDetails userDetails = (MyUserDetails) tokenStore.readAuthentication(auth.split(" ")[0]).getPrincipal();

        User user = userDetails.getUser();

        return user.getUserName() + ":" + user.getPassword();
    }
}
