package com.xt.springcloud.service;

import com.xt.springcloud.entity.Dept;

import java.util.List;

public interface DeptService {

    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
