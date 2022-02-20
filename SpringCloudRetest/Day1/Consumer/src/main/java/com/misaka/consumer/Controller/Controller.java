package com.misaka.consumer.Controller;

import com.misaka.provider.ServiceImp.PayServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class Controller {
//    通过restTemplate 来 请求
//    创建用户
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/consumer/create/{Deatail}")
    public Map Create(@PathVariable String Deatail){
        return restTemplate.getForObject("http://localhost:8001/"+"create/"+Deatail,Map.class);
    }
    @RequestMapping("/consumer/serch/{id}")
    public Map Serch(@PathVariable Integer id){
        return restTemplate.getForObject("http://localhost:8001/"+"serch/"+id,Map.class);
    }
}
