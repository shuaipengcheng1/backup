package com.day8.day8_payconsumer.Service;

import org.springframework.stereotype.Component;

@Component
public class OpenFeignServiceImpl implements OpenFeignService {
    @Override
    public String pay(int id) {
        return "服务端出错";
    }
}
