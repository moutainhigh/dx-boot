package com.dx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dx.bean.Student;
import com.dx.repository.StudentMapper;
import com.dx.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: yaoj
 * @Date: 2018/8/28 22:16
 * 版权所有：Copyright 2018 by 文理电信
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
