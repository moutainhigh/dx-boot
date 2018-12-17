package com.dx.security.core.properties;

import lombok.Data;

/**
 * 图片验证码配置类
 *
 * @author yaoj
 * @version 1.0
 * @copyright 广州明动软件有限公司 Copyright (c) 2018
 * @since 2018-12-17
 */
@Data
public class ImageCodeProperties {

    //图片宽
    private int width = 67;
    //图片高
    private int height = 23;
    //验证码字符个数
    private int length = 4;
    //过期时间
    private int expireIn = 60;

}
