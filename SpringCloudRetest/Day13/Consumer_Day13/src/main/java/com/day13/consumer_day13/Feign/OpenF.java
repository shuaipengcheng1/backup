package com.day13.consumer_day13.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("provider")
@Component
public interface OpenF {
    @RequestMapping("/xx")
    public String p();
}
