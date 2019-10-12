package com.dx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dx.security.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}