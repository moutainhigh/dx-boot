package com.dx.bean;

import com.dx.validata.Insert;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-4-15
 */
@Data
public class Student implements Serializable {

    @NotBlank(message = "id不能为空",groups = Insert.class)
    private String id;

    @NotNull(message = "age不能为空")
    private Integer age;


    public Student(String id,Integer age) {
        this.id = id;
        this.age = age;
    }

    public Student() {
    }
}
