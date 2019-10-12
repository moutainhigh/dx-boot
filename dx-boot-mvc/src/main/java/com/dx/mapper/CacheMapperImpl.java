package com.dx.mapper;

import com.dx.security.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: com.dx.mapper
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/9/26
 */
@Component
@Slf4j
public class CacheMapperImpl implements CacheMapper {


    @Override
    public List<Student> getStudent(int num) {


        log.info("-------------->>>>>>>>>>>>>>>>>进入mapper中查询数据>>>>>>>>>>>>>>>>>>>>>>");

        List<Student> studentList = new ArrayList<>();

        if (num == 1){
            Student student01 = new Student("1",21);
            studentList.add(student01);
            return studentList;
        }

        Student student02 = new Student("2",22);
        studentList.add(student02);

        return studentList;
    }
}
