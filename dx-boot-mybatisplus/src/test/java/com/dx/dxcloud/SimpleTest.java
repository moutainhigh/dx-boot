package com.dx.dxcloud;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dx.security.bean.Teacher;
import com.dx.repository.TeacherMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Description: com.dx
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/1
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testTeacherMapper(){


        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();

        teacherQueryWrapper.orderByDesc("id");

        teacherQueryWrapper.nested(wq->wq.eq("name","tom"));

        teacherQueryWrapper.select("name");


        teacherQueryWrapper.select(Teacher.class,info->info.getColumn().equals("id"));

        List<Teacher> teachers = teacherMapper.selectList(null);

        teachers.forEach(System.out::println);

    }


    @Test
    public void testTeacherMapper2(){


        LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = Wrappers.<Teacher>lambdaQuery();

        teacherLambdaQueryWrapper.like(Teacher::getName,"1000");

        teacherLambdaQueryWrapper.nested(teacherLambdaQueryWrapper1 -> teacherLambdaQueryWrapper.eq(Teacher::getId,"1"));

        List<Teacher> teachers = teacherMapper.selectList(teacherLambdaQueryWrapper);

        teachers.forEach(System.out::println);

    }


    @Test
    public void testTeacherMapper3(){
        List<Teacher> teachers = teacherMapper.getById("1");
        teachers.forEach(System.out::println);

    }


    /**
     * nested
     */
    @Test
    public void testTeacherMapper4(){
        LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = Wrappers.<Teacher>lambdaQuery();

        teacherLambdaQueryWrapper.nested(teacherLambdaQueryWrapper1 -> teacherLambdaQueryWrapper.eq(Teacher::getId,"1").like(Teacher::getName,"0")).like(Teacher::getName,"1");

        List<Teacher> teachers = teacherMapper.getByQw(teacherLambdaQueryWrapper);

        teachers.forEach(System.out::println);

    }

    /**
     * 分页
     */
    @Test
    public void testTeacherMapper5(){

        LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = Wrappers.<Teacher>lambdaQuery();
        teacherLambdaQueryWrapper.like(Teacher::getName,"1");

        Page<Teacher> teacherPage = new Page<>(2,2);


        IPage<Teacher> teacherIPage = teacherMapper.selectPage(teacherPage, teacherLambdaQueryWrapper);

        System.out.println(teacherIPage);
    }

    /**
     * 分页
     */
    @Test
    public void testTeacherMapper6(){

        LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = Wrappers.<Teacher>lambdaQuery();
        teacherLambdaQueryWrapper.like(Teacher::getName,"1");

        Page<Teacher> teacherPage = new Page<>(2,2,false);


        IPage<Teacher> teacherIPage = teacherMapper.selectPage(teacherPage, teacherLambdaQueryWrapper);

        System.out.println(teacherIPage);
    }


    @Test
    public void testTeacherMapper7(){

        LambdaUpdateWrapper<Teacher> eq = Wrappers.<Teacher>update().lambda().eq(Teacher::getId, "1").set(Teacher::getName,null);

        int update = teacherMapper.update(null, eq);
        System.out.println(update);

    }

}
