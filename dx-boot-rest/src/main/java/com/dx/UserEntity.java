package com.dx;

import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-25
 */
@Data
public class UserEntity implements Serializable {

    /**
     *
     */
    private String id;

    private String username;

    private String password;

    private Integer age;

    private String email;

    public UserEntity(String id, String username, String password, Integer age, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
    }
}
