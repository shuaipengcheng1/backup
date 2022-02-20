package com.example.sentinel.Service;

import org.springframework.stereotype.Component;

@Component
public class PayServiceImpl implements PayService {
    @Override
    public String pay(int id) {
        return "订单";
    }
}
