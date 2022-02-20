package com.day11.payservice.Controller;

import com.day11.payservice.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//刷新
@RefreshScope
public class index {
    @Autowired
    PayServiceImpl payService;

    @RequestMapping("/pay/{id}")
    public String p(@PathVariable("id") int id) {
        return payService.pay(id);
    }

    //    获取的配置文件
    @Value("${config.dev}") //获取在github上配置文件的数据 如 config.dev=xxxx   这里就可以获取到 xxx
            String config;

    @RequestMapping("/config")
    public String ps() {
        return config;
    }
}
