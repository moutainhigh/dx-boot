package com.dx.mvc.service;

import com.dx.mvc.bean.Student;
import com.dx.mvc.mapper.CacheMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: com.dx.service
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/26
 */
//@CacheConfig(cacheNames = "studentList")
@Service
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheMapper cacheMapper;


    @Cacheable(value = "studentList", key = "#num")
    //@Cacheable
    @Override
    public List<Student> getStudent(int num) {

        List<Student> studentList = cacheMapper.getStudent(num);

        //制造service异常
//        if (true){
//            throw new NullPointerException("自定义的空指针异常");
//        }

        return studentList;
    }

    @Override
    public String getString(String formdata) {
        return "从数据库中获取的数据";
    }

    //@Cacheable
    @Override
    public List<Student> getDefualt(int num) {

        List<Student> studentList = cacheMapper.getStudent(num);
        return studentList;
    }
}
