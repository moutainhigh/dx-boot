package com.dx.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2019
 * @since 2019-4-15
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class BaseTestController {


    @GetMapping("/get")
    public String get() {
        return "get";
    }

    @RequestMapping("/test/{parm}")
    public String test(@PathVariable String parm) {

        log.info("parm :   " + parm);

        return "ok";
    }


}
