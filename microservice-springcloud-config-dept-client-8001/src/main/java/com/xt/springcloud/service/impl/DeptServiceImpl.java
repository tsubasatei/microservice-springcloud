package com.xt.springcloud.service.impl;

import com.xt.springcloud.entity.Dept;
import com.xt.springcloud.mapper.DeptMapper;
import com.xt.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Transactional
    @Override
    public boolean add(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Transactional(readOnly = true)
    @Override
    public Dept get(Long id) {
        return deptMapper.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dept> list() {
        return deptMapper.findAll();
    }
}
