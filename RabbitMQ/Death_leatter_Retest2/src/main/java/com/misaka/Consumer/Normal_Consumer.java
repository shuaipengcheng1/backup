package com.misaka.Consumer;

import com.misaka.Util.Connection;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;

import java.util.HashMap;
import java.util.Map;

public class Normal_Consumer {
//    交换机
    public static String n_exchange ="n_e";
    public static String d_exchange="d_e";
//    队列
    public static String n_que="n_q";
    public static String d_que="d_q";
//    路由
    public static String n_routerKey ="n";
    public static String d_routerKey ="d";

    public static void main(String[] args) throws Exception{
//  获取频道
        Channel channel = Connection.GET();
//        定义交换机
        channel.exchangeDeclare(n_exchange, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(d_exchange,BuiltinExchangeType.DIRECT);
//        定义队列
        Map map =new HashMap();
        map.put("x-max-length",6);
        map.put("x-dead-letter-exchange",d_exchange);
        map.put("x-dead-letter-routing-key",d_routerKey);
        channel.queueDeclare(n_que,true,false,false,map);
//        定义死信队列
        channel.queueDeclare(d_que,true,false,false,null);
//        绑定交换机与队列
        channel.queueBind(n_que,n_exchange,n_routerKey);
        channel.queueBind(d_que,d_exchange,d_routerKey);
//        监听队列
        channel.basicConsume(n_que,false,(Tag,message)->{
            String s = new String();
System.out.println(s.equals("第5条消息"));
            if(s.equals("第5条消息")){
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            }else {
                System.out.println(new String(message.getBody()));
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);

            }
        },(Tag)->{});
    }
}
