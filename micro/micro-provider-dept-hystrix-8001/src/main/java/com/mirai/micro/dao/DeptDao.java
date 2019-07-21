package com.mirai.micro.dao;

import com.mirai.micro.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptDao {
    boolean addDept(Dept dept);
    Dept findById(long id);
    List<Dept> findAll();
}
