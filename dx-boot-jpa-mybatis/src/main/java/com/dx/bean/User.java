package com.dx.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/18
 */
@Table(name = "t_user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 姓名
     */
    @Column
    private String name;

    /**
     * 年龄
     */
    @Column
    private Integer age;

}
