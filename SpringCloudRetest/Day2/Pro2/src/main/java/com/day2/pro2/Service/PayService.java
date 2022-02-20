package com.day2.pro2.Service;


import com.day2.pro2.Domain.Payment;

public interface PayService {
    Boolean Create(String Detail);
    Payment Select(int id);
}
