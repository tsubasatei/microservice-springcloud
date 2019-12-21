package com.xt.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // EurekaServer服务器端启动类，接受其他微服务注册进来
@SpringBootApplication
public class Config_Git_EurekaServer_App {

    public static void main(String[] args) {
        SpringApplication.run(Config_Git_EurekaServer_App.class, args);
    }
}
