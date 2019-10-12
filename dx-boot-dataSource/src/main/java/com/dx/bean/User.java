package com.dx.security.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/7/4
 */
@Entity(name = "t_test_user")
@Data
public class User{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String userName;
    @Column
    private String email;


}