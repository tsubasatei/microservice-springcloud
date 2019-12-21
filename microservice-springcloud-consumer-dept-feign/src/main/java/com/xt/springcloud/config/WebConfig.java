package com.xt.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.xt.springcloud.service.DeptClientServiceFallbackFactory;
import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced // SpringCloudRibbon 是基于NetflixRibbon实现的一套客户端负载均衡的工具
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public IRule myRule() {
//        return new RandomRule(); // 达到的目的，用重新选择的随即短发替换默认的轮询
        return new RetryRule(); // 达到的目的，用重新选择的随即短发替换默认的轮询
    }


    // org.springframework.cloud.netflix.feign.FeignClientsConfiguration.HystrixFeignConfiguration
//    @Bean
//    @Scope("prototype")
//    public Feign.Builder feignHystrixBuilder() {
//        return Feign.builder();
//    }
}
