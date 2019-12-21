package com.xt.springcloud.controller;

import com.xt.springcloud.entity.Dept;
import com.xt.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/dept")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping
    public boolean add(Dept dept) {
        return deptService.add(dept);
    }

    @GetMapping("/{id}")
    public Dept get(@PathVariable Long id) {
        return deptService.get(id);
    }

    @GetMapping("/list")
    public List<Dept> list() {
        return deptService.list();
    }

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("****" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICE-SPRINGCLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getUri());
        }
        return this.discoveryClient;
    }
}
