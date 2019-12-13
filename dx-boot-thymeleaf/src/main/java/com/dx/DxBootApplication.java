package com.dx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DxBootApplication  {//extends SpringBootServletInitializer

    public static void main(String[] args) {
        SpringApplication.run(DxBootApplication.class, args);
    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(DxBootApplication.class);
//    }

}
