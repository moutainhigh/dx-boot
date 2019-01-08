package com.dx.security.core.validate.code.sms;

/**
 * Description:短信验证码发送接口
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public interface SmsCodeSender {

    /**
     * 发送验证码短信
     *
     * @param mobile 接收验证码的手机号
     * @param code   验证码
     */
    void send(String mobile, String code);
}
