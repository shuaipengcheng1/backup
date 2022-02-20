package com.day9.payservice_day9.Service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Component
@DefaultProperties(defaultFallback = "fallback")
public class PayServiceImpl implements PayService {
    @Override
         //熔断四要素 1 开启熔断 2 设置时长 3 在时长中请求数量最低值 4 在时长中请求数量达标后 请求的失败率 高于设置失败率则开启熔断
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    public String Pay(int id) {
//
        if(id<0){
            throw new RuntimeException();
        }else
        return "订单";
    }
    public String fallback(){
        return "fallback";
    }
}
