package com.xt.springcloud.service;

import com.xt.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 服务降级
 * 修改 microservicecloud-api 工程，根据已经有的 DeptClientService 接口

 * 新建一个实现了 FallbackFactory 接口的类 DeptClientServiceFallbackFactory
 */

/**
 * web 服务客户端负载均衡
 */
//@FeignClient(value = "MICROSERVICE-SPRINGCLOUD-DEPT")
@FeignClient(value = "MICROSERVICE-SPRINGCLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept")
    boolean add(Dept dept);

    @GetMapping("/dept/{id}")
    Dept get(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    List<Dept> list();

}
