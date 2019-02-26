package com.dx.controller;

import com.dx.bean.Student;
import com.dx.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/MybatisPlusStudentController")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 测试list查询
     * @return
     */
    @RequestMapping("/getStudentList")
    public List<Student> getStudentList(){
        List<Student> studentList = studentService.list(null);
        return studentList;
    }

    /**
     * 测试查询
     * @return
     */
    @RequestMapping("/selectById")
    public Object selectById(){
        Student student = new Student();
        student.setId("1");
        Student student1 = student.selectById();
        return student1;
    }

    /**
     * 测试插入  枚举类型的数据   +++
     * @return
     */
    @RequestMapping("/testInsert")
    public Object testInsert(){
        Student student = new Student();
        //student.setId("5");
        student.setName("test");
        boolean insert = student.insert();
        return insert;
    }

    /**
     * 测试从前台获取枚举型的数据   插入
     * @return
     */
    @RequestMapping("/testInsertEnum")
    public Object testInsertEnum(Student student){

        student.setName("asdjflasf");
        boolean insert = student.insert();
        return insert;
    }



    /**
     * 测试从前台获取枚举型的数据   插入
     * @return
     */
    @RequestMapping("/getListEnum")
    public Object getListEnum(){
        List<Student> studentList = studentService.list(null);
        for (Student student1 : studentList) {
            System.out.println(student1);
        }
        return studentList;
    }

    @RequestMapping("/getStudentInfo")
    public Object getStudentInfo(){
        Student student =studentService.getgetStudentInfo();
        return student;
    }


}
