package com.day12.stream_provider_day12.Controller;

import com.day12.stream_provider_day12.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    PayServiceImpl payService;
    @RequestMapping("/pay/{id}")
    public String p(@PathVariable("id") int id){
        System.out.println("xx");
        return payService.Pay(id);
    }
}
