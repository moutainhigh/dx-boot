package com.dx.security.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Description: com.dx.bean
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019/6/1
 */
@Data
@TableName("t_teacher")
public class Teacher {

    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    @TableField("real_name")
    private String name;

    /**
     * 临时名字
     */
    @TableField(exist = false)
    private String tempName;

}
