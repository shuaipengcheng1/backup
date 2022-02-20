package com.misaka.data_model.Dao;

import com.misaka.data_model.Domain.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {
//    查找商品
    Goods findGoods(String info);
//    减少库春
    int Decrese(int id);
}
