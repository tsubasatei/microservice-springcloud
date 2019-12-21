package com.xt.springcloud.controller;

import com.xt.springcloud.entity.Dept;
import com.xt.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/consumer/dept")
@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service;

    @GetMapping("/list")
    public List<Dept> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @PostMapping
    public Boolean add(Dept dept) {
        return service.add(dept);
    }
}
