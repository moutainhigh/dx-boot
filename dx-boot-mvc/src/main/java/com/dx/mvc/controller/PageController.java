package com.dx.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: com.dx.mvc.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/9
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("/toPage")
    public String toPage(String id){

        return "index";
    }



}
