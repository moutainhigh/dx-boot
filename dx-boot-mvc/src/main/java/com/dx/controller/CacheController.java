package com.dx.controller;

import com.dx.bean.Student;
import com.dx.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Object getStudent(int num){

        List<Student> studentList = cacheService.getStudent(num);

        return studentList;
    }



}
