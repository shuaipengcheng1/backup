package com.misaka.nacos_provider.Service;

import org.springframework.stereotype.Component;

@Component
public class PayServiceImpl implements PayService {
    @Override
    public String p(int id) {
        return "订单";
    }
}
