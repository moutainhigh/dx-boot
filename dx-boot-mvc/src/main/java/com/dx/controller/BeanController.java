package com.dx.controller;

import com.dx.bean.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description: com.dx.mvc
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/12
 */
@RestController
public class BeanController {


    @RequestMapping("/save")
    public String save(Teacher teacher){




        return "数据保存成功";
    }



}
