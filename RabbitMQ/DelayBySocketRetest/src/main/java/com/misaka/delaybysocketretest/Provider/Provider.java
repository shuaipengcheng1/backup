package com.misaka.delaybysocketretest.Provider;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/ttl")
@RestController

public class Provider {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @GetMapping("/send/{message}/{ttl}")
    public void get(@PathVariable String message,@PathVariable Integer ttl){
//        fasong
        rabbitTemplate.setConfirmCallback((msg,mul,s)->{
            System.out.println(s);
        });

        rabbitTemplate.convertAndSend("Retest_Socket","N_R",message,(msg)->{
            //设置过期时长

            msg.getMessageProperties().setDelay(ttl);
            return msg;
        });
    }

//    发布确认
    @RequestMapping("/confirm/{message}")
    public void Pro(@PathVariable String message){
        CorrelationData correlationData =new CorrelationData(message);
   rabbitTemplate.convertAndSend("confirm.exchange","key1",message,correlationData);
        rabbitTemplate.convertAndSend("confirm.exchange","key12",message,correlationData);

    }

}
