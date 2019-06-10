package com.dx.wx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.wx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/10
 */
@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "ok";
    }

}
