package com.dx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DxRabbitmqAllBootApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DxRabbitmqAllBootApplication.class, args);
    }

}
