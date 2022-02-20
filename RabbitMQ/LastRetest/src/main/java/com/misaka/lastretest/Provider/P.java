package com.misaka.lastretest.Provider;

import com.misaka.lastretest.Config.NameUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbit")
public class P {
    //    获取rabbitmq对象
    @Autowired
    RabbitTemplate rabbitTemplate = new RabbitTemplate();

    @RequestMapping("/send/{message}/{routingkey}")
    public void mess(@PathVariable String message,@PathVariable String routingkey){
//        根据输入的routing来发送自定的队列

            rabbitTemplate.convertAndSend(NameUtil.normal_Exchange,routingkey,message);

    }
//延迟
    @RequestMapping("/ttl/{message}/{time}")
    public void delay(@PathVariable String message,@PathVariable Integer time){
//        延迟发送
        rabbitTemplate.convertAndSend(NameUtil.DelayedExchange,NameUtil.DelayedRoutingKey,message,(msg)->{
//           设置延迟
            msg.getMessageProperties().setDelay(time);
            return msg;
        });
    }
}
