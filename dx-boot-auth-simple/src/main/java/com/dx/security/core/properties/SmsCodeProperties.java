package com.dx.security.core.properties;

import lombok.Data;

/**
 * Description:短信验证码配置类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
public class SmsCodeProperties {

    /**
     * 验证码字符个数
     */
    private int length = 4;

    /**
     * 过期时间
     */
    private int expireIn = 60;

    /**
     * 拦截的url
     */
    private String url;

}
