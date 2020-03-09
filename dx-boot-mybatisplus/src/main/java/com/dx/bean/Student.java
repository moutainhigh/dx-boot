package com.dx.bean;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 教室类
 * @author: yaoj
 * @Date: 2018/10/1 10:55
 * 版权所有：Copyright 2018 by 文理小电信
 */
@Data
@Accessors()
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
    @TableField("name")
    private String stuName;

    /**
     * 逻辑删除
     */
    @TableLogic
    private String isDel;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
