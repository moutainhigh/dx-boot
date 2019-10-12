package com.dx.security.controller;

import com.dx.security.bean.CacheBean;
import com.dx.security.bean.Student;
import com.dx.security.service.CacheService;
import com.dx.util.ValidatorUtils;
import com.dx.validata.ViliGroupOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: com.dx.controller
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/26
 */
@RestController
public class CacheController {

    @Autowired
    private CacheService cacheService;



    @GetMapping("/cache/get")
    public Object getStudent(
//            @Validated
//            @Range(min = 5, max = 9, message = "num只能从5-9")
//                    int num
            @Validated({ViliGroupOne.class})
            CacheBean cacheBean
    ){

        ValidatorUtils.validateEntity(cacheBean, ViliGroupOne.class);

        List<Student> studentList = cacheService.getStudent(cacheBean.getNum());

        return studentList;
    }



}
