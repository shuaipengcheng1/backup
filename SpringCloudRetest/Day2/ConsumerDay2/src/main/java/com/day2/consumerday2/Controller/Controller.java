package com.day2.consumerday2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;
    @RequestMapping("/consumer/create/{detail}")
    public Map cre(@PathVariable String detail){
        return restTemplate.getForObject("http://PAY/create/"+detail,Map.class);
    }
    @RequestMapping("/consumer/serch/{id}")
    public Map Select(@PathVariable int id){
        return restTemplate.getForObject("http://PAY/Select/"+id,Map.class);
    }

}
