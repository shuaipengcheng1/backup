package com.misaka.nacos_consumer.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "PayService-GateWay")
@Component
public interface FeignService {
//    调用网关的断言路径 Feign的原理
//    1 Feign会去对应的注册中心中找对应微服务的所有提供者
//    2 依照这边提供的RequestMapping值 来访问对应的微服务提供者 例如 一个提供者的ip为 http://localhost:7001 然后这边的Request通过后
//      就会把 ResquestMapping的值拼接上去 变为 http://localhost:7001/pay/{id[controller类给id赋值]}?id=1
    @RequestMapping("/pay/{id}?id=1")
    public String p(@PathVariable("id") int id);
}
