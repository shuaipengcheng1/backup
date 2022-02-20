package com.example.day11_consumer.Service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Component
@FeignClient(value = "PAYSERVICE",fallback = FeignServiceFallBack.class)
public interface FeignService {
    @RequestMapping("/pay/{id}")
    public String p(@PathVariable("id") int id);
}
