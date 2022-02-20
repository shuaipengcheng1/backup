package com.day4.p1.Pro;

import com.day4.p1.Service.PayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Provider {
    @Autowired
    PayServiceImpl payService;
    @Value("${server.port}")
    String Port;

    @RequestMapping("/create/{Detail}")
    public Map re(@PathVariable String Detail) {
        Boolean re = payService.create(Detail);
        Map map = new HashMap();

        if (re) {
            map.put("state", true);
            map.put("message", "成功");
            map.put("port",Port);
            return map;
        } else {
            map.put("state", false);
            map.put("message", "失败");
            map.put("port",Port);

            return map;
        }
    }
}
