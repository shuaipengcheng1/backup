package com.day7.servicefuse.Controller;

import com.day7.servicefuse.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class indexController {
    @Autowired
    PayServiceImpl payService;

    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable("id") int id) {
        return payService.pay(id);
    }
}
