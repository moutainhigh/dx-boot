package com.dx.mvc.controller;

import com.dx.mvc.bean.Student;
import com.dx.mvc.validata.Insert;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-4-15
 */
@RestController
@Slf4j
public class TestValidationController {



    @RequestMapping("/testvalidate")
    public String test(@Validated(value = Insert.class) Student student) {


        List<String> list = Lists.newArrayList();
        log.info("学生的结果是" + student);

        return "ok";
    }


}
