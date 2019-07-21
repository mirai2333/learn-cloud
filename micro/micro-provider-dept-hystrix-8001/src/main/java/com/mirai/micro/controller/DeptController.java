package com.mirai.micro.controller;

import com.mirai.micro.entity.Dept;
import com.mirai.micro.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    public boolean addDept(@RequestBody Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("list")
    public List<Dept> findAll() {
        return deptService.findAll();
    }

    @GetMapping("get/{deptNo}")
    @HystrixCommand(fallbackMethod = "fallBack")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        Dept dept = deptService.findById(deptNo);
        if (dept == null) {
            throw new RuntimeException();
        }
        return dept;
    }

    public Dept fallBack(@PathVariable("deptNo") Long deptNo) {
        return new Dept().setDeptNo(deptNo).setDeptName("该ID没有对应信息").setDbSource("invalid data!");
    }
}
