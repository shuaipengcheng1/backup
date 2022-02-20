package com.day2.pro2.Dao;


import com.day2.pro2.Domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
    int Create(Payment payment);
    Payment Select(int id);
}
