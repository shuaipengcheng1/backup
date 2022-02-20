package com.day2.pro2.Service;

import com.day2.pro2.Dao.PayDao;
import com.day2.pro2.Domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayServiceImpl implements PayService {
//    dao
    @Autowired
PayDao payDao;
    @Override
    public Boolean Create(String Detail) {
        String id = String.valueOf(Math.random()*100000);
        Payment payment=new Payment(id,Detail);
       int i=  payDao.Create(payment);
       if(i!=0){
           return true;
       }else
        return false;
    }

    @Override
    public Payment Select(int id) {
        return payDao.Select(id);
    }
}
