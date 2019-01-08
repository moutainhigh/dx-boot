package com.dx.security.core.validate.code.sms;

/**
 * Description:默认的短信验证码发送类
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-03
 */
public class DefaultSmsCodeSender implements SmsCodeSender {

    /**
     * 调用发送短信
     *
     * @param mobile
     * @param code
     */
    @Override
    public void send(String mobile, String code) {
        System.err.println("向手机 :" + mobile + " 发送短信验证码 :" + code);
    }

}
