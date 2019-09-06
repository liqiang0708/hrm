package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Redis_9005_Application {
    public static void main(String[] args) {
        SpringApplication.run(Redis_9005_Application.class,args);
    }
}
