package com.day5.provider_1.Provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Pro {
    @Value("${server.port}")
    String port;
    @RequestMapping("/PAY")
    public Map P(){
        Map map  =new HashMap();
        map.put("state",200);
        map.put("message","成功");
        map.put("server",port);
        return map;
    }
}
