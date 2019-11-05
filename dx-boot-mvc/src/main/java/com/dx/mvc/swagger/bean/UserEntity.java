package com.dx.mvc.swagger.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-02-25
 */
@Data
@ApiModel(value="user对象",description="用户对象user")
public class UserEntity implements Serializable {

    @ApiModelProperty(value="状态",name="id",required=true)
    private String id;

    @ApiModelProperty(value="用户名",name="username",example="xingguo")
    private String username;

    @ApiModelProperty(value="密码",hidden=true)
    private String password;


}
