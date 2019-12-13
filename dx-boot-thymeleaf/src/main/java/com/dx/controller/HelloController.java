package com.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/12/9
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/index/{data}")
    public String index(Model model, @PathVariable String data) {
        model.addAttribute("key", data);
        return "index";
    }

    @GetMapping("/index2/{data}")
    public String index3(Model model, @PathVariable String data) {
        model.addAttribute("key", data);
        return "index2";
    }
}
