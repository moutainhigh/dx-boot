package com.dx.bean;

import com.dx.group.Insert;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-4-15
 */
@Data
@RequiredArgsConstructor(staticName = "of")
public class Student {

    @NotBlank(message = "id不能为空",groups = Insert.class)
    private String id;

    @NotNull(message = "age不能为空")
    private Integer age;


}
