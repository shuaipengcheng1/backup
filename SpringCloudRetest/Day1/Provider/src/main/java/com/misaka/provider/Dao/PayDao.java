package com.misaka.provider.Dao;

import com.misaka.Domain.Pay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PayDao {
    public int Create(Pay pay);
    public Pay SelectPaytById(int id);
}
