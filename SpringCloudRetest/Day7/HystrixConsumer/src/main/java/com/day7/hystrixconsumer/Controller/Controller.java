package com.day7.hystrixconsumer.Controller;

import com.day7.hystrixconsumer.OpenFeignServie.OpenFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    OpenFeign openFeign;
    @RequestMapping("/consuemr/{id}")
    public String Pay(@PathVariable("id") int id){
        if(id==10){
            throw new RuntimeException("小了");
        }else
      return   openFeign.pay(id);
    }
}
