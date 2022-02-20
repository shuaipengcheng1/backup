package com.misaka.nacos_provider2.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PayServiceImpl implements PayService {
    @Value("${server.port}")
    String port;
    @Override
    public String pay(int id) {
        return port+"订单";
    }
}
