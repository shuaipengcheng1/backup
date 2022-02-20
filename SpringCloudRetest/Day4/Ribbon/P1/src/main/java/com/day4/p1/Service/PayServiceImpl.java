package com.day4.p1.Service;

import com.day4.p1.Dao.PayDao;
import com.day4.p1.Domain.Pay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayDao payDao;
    @Override
    public Boolean create( String Detail) {
//生成随机id
        String id = String.valueOf(Math.random()*100000);
        Pay pay =new Pay(id,Detail);
        int re = payDao.create(pay);
        if(re!=0){
            return true;
        }else
        return false;
    }
}
