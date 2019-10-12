package com.dx.security.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 教室类
 * @author: yaoj
 * @Date: 2018/10/1 10:55
 * 版权所有：Copyright 2018 by 文理小电信
 */
@Data
@TableName("t_student")
@Entity
@Table(name = "t_student")
public class Student extends Model<Student> {
    /**
     * 学生id
     */
    @Id
    @TableId("id")
    private String id;

    /**
     * 学生姓名
     */
    @Column(name = "name")
    @TableField("name")
    private String stuName;

    /**
     * 逻辑删除
     */
    @Column
    @TableLogic
    private String isDel;



    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}