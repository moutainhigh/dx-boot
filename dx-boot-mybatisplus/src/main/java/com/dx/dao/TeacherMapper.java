package com.dx.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.dx.bean.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description: com.dx.dao
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/1
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    @Select("select * from t_teacher where id  = #{id}")
    List<Teacher> getById(@Param("id") String id);


    @Select("select * from t_teacher ${ew.customSqlSegment}")
    List<Teacher> getByQw(@Param(Constants.WRAPPER)Wrapper<Teacher> wrapper);
}
