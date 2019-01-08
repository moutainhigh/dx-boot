package com.dx.security.core.properties;

import lombok.Data;


/**
 * Description:验证码配置
 * 验证码配置,验证码有图片验证码、短信验证码等，所以再包一层
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
@Data
public class ValidateCodeProperties {

    /**
     * 图片验证码配置
     */
    private ImageCodeProperties image = new ImageCodeProperties();

    /**
     * 短信验证码配置
     */
    private SmsCodeProperties sms = new SmsCodeProperties();

}
