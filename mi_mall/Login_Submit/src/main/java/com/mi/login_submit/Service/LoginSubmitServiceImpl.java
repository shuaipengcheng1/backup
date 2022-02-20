package com.mi.login_submit.Service;

import com.mi.login_submit.Dao.LoginSubmit;
import com.mi.login_submit.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginSubmitServiceImpl implements LoginSubmitService {
    @Autowired
    LoginSubmit loginSubmit;
    @Override
    public User Login(String username, String password) {
        User state = loginSubmit.Login(username,password);
        return state;

    }

    @Override
    public Boolean Submit(String username, String password) {
        int state = loginSubmit.Submit(username,password);
        if(state>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Boolean Check_Name(String username){
        User state = loginSubmit.Check_Name(username);
        if(state!=null){
            return false;
        }else {
            return true;
        }
    }

}
