package com.liqiang.hrm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.liqiang.hrm.mapper")
@EnableFeignClients//启用  才能实现内部调用  去 获取全文检索模块的 client
public class Course_9002_Application {
    public static void main(String[] args) {
        SpringApplication.run(Course_9002_Application.class,args);
    }
}
