package com.mi.login_submit.Dao;

import com.mi.login_submit.Domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginSubmit {
    //    登录方法
    public User Login(String username, String password);

    //    注册方法
    public int Submit(String username, String password);
//    检查是否重名
    public User Check_Name(String username);

}
