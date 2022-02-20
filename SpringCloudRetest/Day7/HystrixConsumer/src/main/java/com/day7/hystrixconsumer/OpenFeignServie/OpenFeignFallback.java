package com.day7.hystrixconsumer.OpenFeignServie;

import org.springframework.stereotype.Component;

@Component
//fallback类
public class OpenFeignFallback implements OpenFeign {
    @Override
    public String pay(int id) {
        return "消费者失败";
    }
}
