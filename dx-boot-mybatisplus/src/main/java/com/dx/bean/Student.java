package com.dx.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 教室类
 * @author: yaoj
 * @Date: 2018/10/1 10:55
 * 版权所有：Copyright 2018 by 文理小电信
 */
@Data
@TableName("t_student")
public class Student extends Model<Student> {
    /**
     * 学生id
     */
    @TableId("id")
    private String id;

    /**
     * 学生姓名
     */
    private String name;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}