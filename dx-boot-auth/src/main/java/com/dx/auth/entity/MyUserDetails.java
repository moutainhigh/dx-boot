package com.dx.auth.entity;

import org.springframework.security.core.userdetails.User;

import java.util.Collections;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-7
 */
public class MyUserDetails extends User {

    private com.dx.auth.entity.User user;

    public MyUserDetails(com.dx.auth.entity.User user) {
        super(user.getUserName(), user.getPassword(), true, true, true, true, Collections.EMPTY_SET);
        this.user = user;
    }

    public com.dx.auth.entity.User getUser() {
        return user;
    }

    public void setUser(com.dx.auth.entity.User user) {
        this.user = user;
    }
}