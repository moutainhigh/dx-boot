package com.dx;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class DxDubboProviderBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(DxDubboProviderBootApplication.class, args);
    }

}
