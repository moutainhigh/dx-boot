package com.dx.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-3-5
 */
@RestController
public class TestController {

    @RequestMapping("hello")
    public String hello(){
        return "hello ok";
    }

}
