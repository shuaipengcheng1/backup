package com.day13.day13_provider.Controller;

import com.day13.day13_provider.Service.PayServiceImpl;
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
        return payService.pay(id);
    }
    @RequestMapping("/xx")
    public String p(){
        return "xx";
    }
}
