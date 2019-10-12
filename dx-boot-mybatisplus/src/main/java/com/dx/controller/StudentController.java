package com.dx.security.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dx.security.bean.Student;
import com.dx.security.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 枚举类型的测试
 * @author: yaoj
 * @Date: 2018/8/1 21:56
 * 版权所有：Copyright 2018 by 文理电信
 */
@Slf4j
@RestController
@RequestMapping
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 测试插入
     * @return
     */
    @RequestMapping("/insert")
    public Object insert(Student student){

        boolean insert = studentService.save(student);
        return insert;
    }

    /**
     * 测试删除
     * @return
     */
    @RequestMapping("/delete/{id}")
    public Object delete(@PathVariable String id){
        boolean b = studentService.removeById(id);
        return b;
    }

    /**
     * 测试插入
     * @return
     */
    @RequestMapping("/update")
    public Object update(Student student){
        boolean update = student.updateById();
        return update;
    }


    /**
     * 测试list查询
     * @return
     */
    @RequestMapping("/getList")
    public List<Student> getList(){
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        studentQueryWrapper.eq("name","张三100");
        //studentQueryWrapper.between("is_del",0,1);
        //studentQueryWrapper.like("name","1000");
        List<Student> studentList = studentService.list(studentQueryWrapper);
        return studentList;
    }

    /**
     * 测试查询
     * @return
     */
    @RequestMapping("/get/{id}")
    public Object get(@PathVariable String id){
        Student student = studentService.getById(id);
        return student;
    }




}
