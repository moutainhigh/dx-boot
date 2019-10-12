package com.dx.security.bean;

import lombok.Data;

import java.util.List;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/12
 */
@Data
public class Teacher {

    private String id;

    private String name;

    private int age;

    private List<Student> studentList;

}
