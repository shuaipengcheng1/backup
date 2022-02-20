package com.day8.day8_payconsumer.Controller;

import com.day8.day8_payconsumer.Service.OpenFeignService;
import com.day8.day8_payconsumer.Service.OpenFeignServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @Autowired
    OpenFeignService openFeignService;
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id){
        return openFeignService.pay(id);
    }
}
