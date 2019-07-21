package com.mirai.micro.service;

import com.mirai.micro.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptConsumerControllerFallback implements FallbackFactory<DeptConsumerService> {
    @Override
    public DeptConsumerService create(Throwable throwable) {
        return new DeptConsumerService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public List findAll() {
                return null;
            }

            @Override
            public Dept findById(Long deptNo) {
                return new Dept().setDeptNo(deptNo).setDeptName("服务已降级").setDbSource("invalid data!");
            }
        };
    }
}
