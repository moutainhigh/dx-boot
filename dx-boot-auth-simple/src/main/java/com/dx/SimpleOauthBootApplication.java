package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 *
 * @author yaoj
 * @version 1.0
 * @copyright Copyright (c) 文理电信
 * @since 2019-01-1
 */
@SpringBootApplication
public class SimpleOauthBootApplication {


    /**
     * http://localhost:8088/oauth/authorize?response_type=code&client_id=demoApp&redirect_uri=http://baidu.com
     *
     * http://localhost:8088/oauth/token
     * grant_type=authorization_code&code=gnyW4f&client_id=client&client_secret=secret&redirect_uri=http://example.com
     *
     *
     * get http://localhost:8088/verifycode/sms?mobile=13786705806
     *head deviceId=1001
     *
     * post http://localhost:8088/authentication/mobile
     * head deviceId=1001 Authorization=     body  mobile=13786705806   smsCode=
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SimpleOauthBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
