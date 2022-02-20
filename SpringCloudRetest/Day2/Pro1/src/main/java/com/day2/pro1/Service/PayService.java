package com.day2.pro1.Service;

import com.day2.pro1.Domain.Payment;

public interface PayService {
    Boolean Create(String Detail);
    Payment Select(int id);
}
