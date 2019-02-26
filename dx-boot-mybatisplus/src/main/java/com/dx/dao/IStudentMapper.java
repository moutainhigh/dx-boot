package com.dx.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface IStudentMapper extends BaseMapper<Student> {

    Integer updateList(List<Student> studentList);

    List<Student> selectMyPage(RowBounds rowBounds, @Param("ew") Wrapper wrapper);


    List<Student> ifChoese();


    Student getgetStudentInfo();
}