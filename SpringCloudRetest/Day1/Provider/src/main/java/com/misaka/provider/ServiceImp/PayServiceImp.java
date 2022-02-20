package com.misaka.provider.ServiceImp;

import com.misaka.Domain.Pay;
import com.misaka.InterFace.PayService;
import com.misaka.provider.Dao.PayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PayServiceImp implements PayService {
//    获取Dao
    @Autowired
    PayDao payDao;
    @Override
    public Pay GetDeatil(int id) {
        return  payDao.SelectPaytById(id);
    }

    @Override
    public Boolean Create(String Detail) {
        Pay pay =new Pay(String.valueOf(Math.random()*100000),Detail);
       int re= payDao.Create(pay);
       if(re!=0){
           return true;
       }else {
           return false;

       }
    }
}
