package com.liqiang.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.liqiang.hrm.mapper")
public class Course_9002_Application {
    public static void main(String[] args) {
        SpringApplication.run(Course_9002_Application.class,args);
    }
}
