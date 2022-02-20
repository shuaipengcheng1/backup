package com.misaka.provider;

import com.misaka.Domain.Pay;
import com.misaka.provider.ServiceImp.PayServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
//    供消费者消费的控制器
    @Autowired
    PayServiceImp payServiceImp;
    @RequestMapping("/create/{Detail}")
    public Map Create(@PathVariable String Detail){
        Boolean state = payServiceImp.Create(Detail);
        Map<String,Object> map = new HashMap<>();
        if(state){
          map.put("state",true);
          return map;
        }else {
            map.put("state",false);
            return map;
        }
    }
    @RequestMapping("/serch/{id}")
    public Map Serch(@PathVariable Integer id){
        Pay re = payServiceImp.GetDeatil(id);
        Map<String,Object> map = new HashMap<>();

        if(re==null){
            map.put("state",false);
            map.put("value",re);
            return map;
        }else {
            map.put("state",true);
            map.put("value",re);
            return map;
        }
    }
}
