package com.misaka.nacos_provider2.Controller;

import com.misaka.nacos_provider2.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class idex {
    @Autowired
    PayServiceImpl payService;
    @RequestMapping("/pay/{id}")
    public String id(@PathVariable("id") int id){
        return payService.pay(id);
    }
}
