package com.liqiang.hrm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//有效，但是为什么呢--依赖了数据库连接，但是没有配置datasource
@EnableEurekaClient
public class RabbitMQ_9007_Application {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMQ_9007_Application.class,args);
    }
}
