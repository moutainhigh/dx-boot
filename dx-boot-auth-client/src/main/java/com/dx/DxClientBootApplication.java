package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableOAuth2Sso
@SpringBootApplication
public class DxClientBootApplication  {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DxClientBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @GetMapping("/user")
    public Authentication user(Authentication  user){
        return user;
    }


}
