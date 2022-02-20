package com.example.user_model.Dao;

import com.example.user_model.Domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User FindUser(int id);

    int Decrease(int price);

}
