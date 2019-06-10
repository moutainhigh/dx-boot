package com.dx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/10
 */
@Controller
public class TestVue {

    @RequestMapping("/getData")
    public ModelAndView getData(Model model){
        System.out.println("data1");

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data1", "sadfasf");
        return new ModelAndView("test",data);

    }

}
