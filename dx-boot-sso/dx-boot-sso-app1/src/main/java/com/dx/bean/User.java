package com.dx.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/17
 */
@Data
public class User implements Serializable {

    private String username;

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
