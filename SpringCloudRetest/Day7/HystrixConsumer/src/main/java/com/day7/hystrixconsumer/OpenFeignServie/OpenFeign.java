package com.day7.hystrixconsumer.OpenFeignServie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "PAY",fallback = OpenFeignFallback.class)
public interface OpenFeign {

    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id);

}
