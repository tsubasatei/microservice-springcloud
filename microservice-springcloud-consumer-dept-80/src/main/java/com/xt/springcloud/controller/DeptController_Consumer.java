package com.xt.springcloud.controller;

import com.xt.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequestMapping("/consumer/dept")
@RestController
public class DeptController_Consumer {

//    public static final String REST_URL_PREFIX = "http://localhost:8001/dept";
    public static final String REST_URL_PREFIX = "http://MICROSERVICE-SPRINGCLOUD-DEPT/dept";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX, dept, Boolean.class);
    }

    @GetMapping("/{id}")
    public Dept get(@PathVariable Long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/" + id, Dept.class);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/list", List.class);
    }

    // 测试 @EnableDiscoveryClient, 消费端可以调用服务发现
    @GetMapping("/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/discovery", Object.class);
    }
}
