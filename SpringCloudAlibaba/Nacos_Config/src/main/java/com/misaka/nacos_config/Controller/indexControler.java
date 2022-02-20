package com.misaka.nacos_config.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//保证动态刷新
@RefreshScope
public class indexControler {
    @Value("${config.info}")
    String c;
    @RequestMapping("/config")
    public String p(){
        return c;
    }
}
