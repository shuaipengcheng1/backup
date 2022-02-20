package com.day13.day13_provider.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class Config {
    @Value("${config.info}")
    String info;
    @RequestMapping("/info/{id}")
    public String p(@PathVariable("id") int id){
        return "info:"+info+"id:"+id;
    }
}
