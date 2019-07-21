package com.mirai.micro.service;

import com.mirai.micro.dao.DeptDao;
import com.mirai.micro.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    private final DeptDao deptDao;

    @Autowired
    public DeptService(DeptDao deptDao) {
        this.deptDao = deptDao;
    }

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    public Dept findById(long id) {
        return deptDao.findById(id);
    }

    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}
