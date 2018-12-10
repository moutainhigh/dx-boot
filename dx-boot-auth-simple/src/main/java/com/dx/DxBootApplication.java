package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@EnableAuthorizationServer
@SpringBootApplication
public class DxBootApplication extends AuthorizationServerConfigurerAdapter {


    /**
     *
     * get  ： localhost:8080/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://www.baidu.com
     *
     * post ：  http://localhost:8080/oauth/token?grant_type=authorization_code&code=kvxEsN&redirect_uri=http://www.baidu.com
     * 注：调用的时候记得把code的值修改
     *
     */


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DxBootApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                .secret("secret") // client_secret
                .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                .scopes("app"); // 允许的授权范围
    }

}
