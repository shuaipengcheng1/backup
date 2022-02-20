package com.day9.payservice_day9.Controller;

import com.day9.payservice_day9.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @Autowired
    PayServiceImpl payServicel;
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id){

       return payServicel.Pay(id);
    }
}
