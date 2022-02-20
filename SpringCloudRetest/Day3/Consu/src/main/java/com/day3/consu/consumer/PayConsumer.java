package com.day3.consu.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class PayConsumer {
    @Autowired
    RestTemplate restTemplate;
//    要使用的微服务名
    String app = "PayService";
    @RequestMapping("/consumer/Pay")
    public Map map(){
return restTemplate.getForObject("http://localhost:8001/service",Map.class);
    }
}
