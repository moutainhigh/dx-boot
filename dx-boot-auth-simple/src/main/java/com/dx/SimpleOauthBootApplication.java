package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

@SpringBootApplication
public class SimpleOauthBootApplication extends AuthorizationServerConfigurerAdapter {


    /**
     * http://localhost:8080/oauth/authorize?response_type=code&client_id=demoApp&redirect_uri=http://baidu.com
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SimpleOauthBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

}
