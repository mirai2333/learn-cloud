package com.mirai.micro.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String test() {
        return "Hello World! " + port;
    }
}
