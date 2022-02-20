package com.day5.openfeign.Config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Component
//获取微服务
@FeignClient("PAY")
public interface OpenFeignConfig {
    @RequestMapping("/PAY")
    public Map P();
}
