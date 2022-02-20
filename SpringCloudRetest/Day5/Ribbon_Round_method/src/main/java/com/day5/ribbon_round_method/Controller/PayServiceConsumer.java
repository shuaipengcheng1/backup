package com.day5.ribbon_round_method.Controller;

import com.day5.ribbon_round_method.LoadBalanced.MyLbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Map;

@RestController
public class PayServiceConsumer {
    @Autowired
//            请求
    RestTemplate restTemplate;
    @Autowired
//            轮询算法
    MyLbImpl myLb;
    @Autowired
//            服务器
    DiscoveryClient discoveryClient;

    @RequestMapping("/consumer/pay")
    public Map pay(){
//        获取服务器列表
      ServiceInstance serviceInstance= myLb.Round(discoveryClient.getInstances("PAY"));
//    获取路径
      URI uri= serviceInstance.getUri();
      return restTemplate.getForObject(uri+"/PAY",Map.class);
    }
}
