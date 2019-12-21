package com.xt.myrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule() {
//        return new RandomRule();  // Ribbon 默认是轮询，自定义为随机
        return new MyRandomRule();
    }

}
