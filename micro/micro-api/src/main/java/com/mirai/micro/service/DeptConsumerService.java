package com.mirai.micro.service;

import com.mirai.micro.entity.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "MICRO-DEPT",fallbackFactory = DeptConsumerControllerFallback.class)
@RequestMapping("/dept/")
public interface DeptConsumerService {
    @GetMapping("add")
    boolean addDept(Dept dept);

    @GetMapping("list")
    List findAll();

    @GetMapping("get/{deptNo}")
    Dept findById(@PathVariable("deptNo") Long deptNo);
}
