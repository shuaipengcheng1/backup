package com.example.day11_consumer.Controller;

import com.example.day11_consumer.Service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    FeignService feignService;
    @RequestMapping("/pay/{id}")
    public String p(@PathVariable("id") int id){
        return feignService.p(id);
    }
}
