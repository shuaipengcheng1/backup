package com.day2.pro1.Controller;

import com.day2.pro1.Domain.Payment;
import com.day2.pro1.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    PayServiceImpl payService;
    @Value("${server.port}")
    String port;
//    创建
    @RequestMapping("/create/{detail}")
    public Map create(@PathVariable String detail){
        Boolean s = payService.Create(detail);
        Map state = new HashMap();
        if(s){
            state.put("state",true);
            state.put("port",port);
            return state;
        }else {
            state.put("state",false);
            state.put("port",port);
            return state;
        }
    }

//    查询
    @RequestMapping("Select/{id}")
    public Map select(@PathVariable int id){
        Payment payment =payService.Select(id);
        Map map = new HashMap();
        if(payment!=null){
            map.put("state",true);
            map.put("value",payment);
            map.put("port",port);
            return map;
        }else {
            map.put("state",false);
            map.put("value",payment);
            map.put("port",port);

            return map;
        }
    }
}
