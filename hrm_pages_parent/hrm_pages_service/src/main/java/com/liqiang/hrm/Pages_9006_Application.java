package com.liqiang.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.liqiang.hrm.mapper")
public class Pages_9006_Application {
    public static void main(String[] args) {
        SpringApplication.run(Pages_9006_Application.class,args);
    }
}
