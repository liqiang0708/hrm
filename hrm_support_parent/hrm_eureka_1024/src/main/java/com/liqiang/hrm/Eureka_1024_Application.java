package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka_1024_Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka_1024_Application.class,args);
    }
}
