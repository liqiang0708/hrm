package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FastDfs_9003_Application {
    public static void main(String[] args) {
        SpringApplication.run(FastDfs_9003_Application.class,args);
    }
}
