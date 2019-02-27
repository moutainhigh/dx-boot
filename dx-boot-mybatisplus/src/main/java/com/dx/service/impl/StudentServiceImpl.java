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

}
