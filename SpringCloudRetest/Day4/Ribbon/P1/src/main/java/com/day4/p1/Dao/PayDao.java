package com.day4.p1.Dao;

import com.day4.p1.Domain.Pay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
//    插入
    int create(Pay pay);
}
