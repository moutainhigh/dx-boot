package com.dx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * dx-cloud
 *
 * @author: yaoj
 * @Date: 2018/11/11 14:07
 * 版权所有：Copyright 2018 by 文理电信
 */
@EnableEurekaServer
@SpringBootApplication
public class EurkaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurkaServerApplication.class, args);
    }
}
