package com.mirai.micro.controller;

import com.mirai.micro.entity.Dept;
import com.mirai.micro.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dept/")
public class DeptController {

    private final DeptService deptService;

    @Autowired
    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @PostMapping("add")
    public boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("list")
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @GetMapping("get/{deptNo}")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        return deptService.findById(deptNo);
    }
}
