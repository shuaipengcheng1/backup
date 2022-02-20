package com.day10.config_client.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class index {
    @Value("${config.dev}") //获取在github上配置文件的数据 如 config.dev=xxxx   这里就可以获取到 xxx
    String config;
    @RequestMapping("/config")
    public String p(){
        return config;
    }

}
