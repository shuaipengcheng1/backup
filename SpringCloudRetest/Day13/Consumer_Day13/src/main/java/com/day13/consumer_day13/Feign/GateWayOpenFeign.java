package com.day13.consumer_day13.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gateway")
public interface GateWayOpenFeign {
    @RequestMapping("/info/{id}?id=10")
    public String info(@PathVariable("id") int id);
}
