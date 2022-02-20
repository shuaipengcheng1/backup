package com.day13.consumer_day13.com;

import com.day13.consumer_day13.Feign.GateWayOpenFeign;
import com.day13.consumer_day13.Feign.OpenF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class index {
    @Autowired
    OpenF openF;
    @Autowired
    GateWayOpenFeign wayOpenFeign;

    @RequestMapping("/x")
    public String p() {
        return openF.p();
    }

    @RequestMapping("/info/{id}")
    public String info(@PathVariable("id") int id) {
        return wayOpenFeign.info(id);
    }
}
