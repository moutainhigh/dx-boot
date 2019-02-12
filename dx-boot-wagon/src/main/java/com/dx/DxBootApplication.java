package com.dx;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DxBootApplication  {

    /**
     * 命令：   mvn clean package wagon:upload-single wagon:sshexec
     *
     *
     *
     *
     */


    public static void main(String[] args) {
        SpringApplication.run(DxBootApplication.class, args);
    }


}
