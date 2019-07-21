package com.mirai.micro.controller;

import com.mirai.micro.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/consumer/dept/")
public class DeptConsumerController {
    private static final String API_PREFIX = "http://MICRO-DEPT";
    private final RestTemplate restTemplate;

    @Autowired
    public DeptConsumerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("add")
    public boolean addDept(Dept dept) {
        Boolean result = restTemplate.postForObject(API_PREFIX + "/dept/add", dept, Boolean.class);
        return result == null ? false : result;
    }

    @GetMapping("list")
    public List findAll() {
        return restTemplate.getForObject(API_PREFIX + "/dept/list", List.class);
    }

    @GetMapping("get/{deptNo}")
    public Dept findById(@PathVariable("deptNo") Long deptNo) {
        return restTemplate.getForObject(API_PREFIX + "/dept/get/" + deptNo, Dept.class);
    }
}
