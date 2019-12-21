package com.xt.springcloud.mapper;

import com.xt.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper{

    boolean addDept(Dept dept);
    Dept findById(Long id);
    List<Dept> findAll();
}
