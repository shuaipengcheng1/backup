package com.day8.paymodel.Service;


import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

@Component
//设置全局fallback
@DefaultProperties(defaultFallback = "fallback")
public class PayServiceImpl implements PayService {

    //    设置断路器
//    四要素 开启断路器 时长 时长内请求阈值 时长内请求失败率
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),   //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), //失败率达到多少后跳闸
    })
    @Override
    public String Pay(int id) {
        if (id < 0) {
            throw new RuntimeException();
        } else {
            return "订单";
        }

    }

    public String fallback() {
        return "fallback";
    }
}
