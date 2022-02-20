package com.day5.openfeign.Consumer;

import com.day5.openfeign.Config.OpenFeignConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Index {
    @Autowired
    OpenFeignConfig openFeignConfig;
    @RequestMapping("/openfeign/pay")
    public Map p(){
        return openFeignConfig.P();
    }
}
