package com.example.sentinel.Controller;

import com.example.sentinel.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    PayServiceImpl payService;
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id){
        if(id<0){
            throw new RuntimeException("not below 0");
        }else {
          return   payService.pay(id);
        }

    }
}
