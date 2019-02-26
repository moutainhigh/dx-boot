package com.dx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.bean.Student;
import com.dx.dao.IStudentMapper;
import com.dx.service.IStudentService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: yaoj
 * @Date: 2018/8/28 22:16
 * 版权所有：Copyright 2018 by 文理电信
 */
@Slf4j
@Service
@Log
public class StudentServiceImpl extends ServiceImpl<IStudentMapper, Student> implements IStudentService {

    @Autowired
    private IStudentMapper studentMapper;

    @Override
    @Transactional
    public boolean saveList() {

        for (int i = 0; i < 10; i++) {
            List<Student> studentList = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                Student student = new Student();
                //student.setId(UUID.randomUUID().toString().replace("-", ""));
                student.setName(i + j + "tttt");
                studentList.add(student);
                Student student2 = new Student();
                //student2.setId(UUID.randomUUID().toString().replace("-", ""));
                student2.setName(i + j + "bbbb");
                studentList.add(student2);
                if (i == 3) {
                    //throw new RuntimeException("你要控制住记子啊！！");
                }
            }
            boolean b = saveBatch(studentList);
            log.info(i + "次结果是" + b);
        }
        return true;
    }

    @Override
    public Student getgetStudentInfo() {
        return studentMapper.getgetStudentInfo();
    }
}
