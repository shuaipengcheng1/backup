package com.mi.login_submit.Service;

import com.mi.login_submit.Domain.User;

public interface LoginSubmitService {
    //    登录方法
    public User Login(String username, String password);

    //    注册方法
    public Boolean Submit(String username, String password);

    public Boolean Check_Name(String username);

}
