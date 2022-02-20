package com.misaka.nacos_provider.Controller;

import com.misaka.nacos_provider.Service.PayServiceImpl;
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
        return payService.p(id);
    }
}
