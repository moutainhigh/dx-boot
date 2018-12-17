package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
@EnableFeignClients
public class DxBootApplication  {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DxBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }


}
