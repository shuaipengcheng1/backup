package com.example.payservice_provider_day14.Service;

import org.springframework.stereotype.Component;

@Component
public class PayServiceImpl implements PayService {
    @Override
    public String pay(int id) {
        return "订单";
    }
}
