package com.dx.security.bean;

import lombok.Data;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/22
 */
@Data
public class User {

    private String name;

    private String nick;

    public User(String name, String nick) {
        this.name = name;
        this.nick = nick;
    }
}
