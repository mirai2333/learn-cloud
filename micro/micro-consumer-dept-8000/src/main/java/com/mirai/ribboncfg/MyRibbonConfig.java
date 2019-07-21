package com.mirai.ribboncfg;

import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRibbonConfig {
    @Bean
    public IRule getMyRule(){
        return new MyRandomRule();
    }
}
