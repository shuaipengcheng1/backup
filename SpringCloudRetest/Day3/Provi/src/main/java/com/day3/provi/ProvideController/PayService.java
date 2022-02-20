package com.day3.provi.ProvideController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PayService {
    @RequestMapping("/service")
    public Map get(){
        Map map = new HashMap();
        map.put("message","订单");
        map.put("code",200);
        return map;
    }
}
