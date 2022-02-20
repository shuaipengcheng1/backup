package com.day4.c.Consumer;

import com.day4.c.Config.MylbImpl;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
public class Controller {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    MylbImpl mylb;

    @RequestMapping("/c/{Detail}")
    public Map map(@PathVariable String Detail) {
        return restTemplate.getForObject("http://PAY/create/" + Detail, Map.class);
    }

    @RequestMapping("/c/lb/{Detail}")
    public Map lb(@PathVariable String Detail) {
//        获取所有可用的服务器
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("PAY");
        URI uri = null;
//        自写lb算法
        if (serviceInstances.size() > 0) {
//            获取到轮询的服务器
            ServiceInstance s = mylb.GetService(serviceInstances);
//获取地址
            uri = s.getUri();

        }
        return restTemplate.getForObject(uri + "/create/" + Detail, Map.class);
    }
}
