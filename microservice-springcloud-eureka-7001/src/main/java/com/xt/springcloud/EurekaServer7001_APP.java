package com.xt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  // Eureka Server 服务端启动类，接受其他微服务注册进来
public class EurekaServer7001_APP {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_APP.class, args);
    }
}
