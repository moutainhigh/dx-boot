package com.dx.test;


import com.dx.security.bean.Student;
import com.dx.dao.StudentRepository;
import com.dx.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * Description: com.dx.test
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/8/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2Test {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 查询测试
     * @throws Exception
     */
    @Test
    public void testFind() throws Exception {

        Student student = studentMapper.selectById("1");
        System.out.println("studentMapper  selectById:" + student);

        System.out.println("--------------------------------");


        Student one = studentRepository.findByStuName("1");

        System.out.println("studentRepository findByStuName :" +one.toString());

        System.out.println("--------------------------------");


        Optional<Student> byId = studentRepository.findById("1");

        Student student1 = byId.orElse(null);

        System.out.println("studentRepository   byId  orElse : " + student1);


    }


}
