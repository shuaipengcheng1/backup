package com.example.day11_consumer.Service;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceFallBack implements FeignService {
    @Override
    public String p(int id) {
        return "客户端报错";
    }
}
