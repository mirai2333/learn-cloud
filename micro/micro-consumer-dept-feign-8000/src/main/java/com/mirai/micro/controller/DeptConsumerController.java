package com.mirai.micro.controller;

import com.mirai.micro.entity.Dept;
import com.mirai.micro.service.DeptConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept/")
public class DeptConsumerController {
    private final DeptConsumerService service;

    @Autowired
    public DeptConsumerController(DeptConsumerService service) {
        this.service = service;
    }

    @GetMapping("add")
    public boolean addDept(Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping("list")
    public List findAll() {
        return service.findAll();
    }

    @GetMapping("get/{deptNo}")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        return service.findById(deptNo);
    }
}
