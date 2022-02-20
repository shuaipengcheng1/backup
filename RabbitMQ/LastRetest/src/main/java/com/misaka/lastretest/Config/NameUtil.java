package com.misaka.lastretest.Config;

import org.springframework.stereotype.Component;

@Component
public class NameUtil {
    //    延迟交换机
    public   static String DelayedExchange = "DelayedExchange";
    //    延迟队列
    public  static String DelayedQueue = "DelayedQueue";
    //    延迟队列的routingKey
    public static String DelayedRoutingKey = "DQ1";

    //    普通交换机
    public static String normal_Exchange = "normalExchange";
    //    普通交换机队列
    public   static String Queue1 = "Queue1";
    public   static String Queue2 = "Queue2";
    //    普通交换机的routingKey
    public  static String Queue1_Key = "1";
    public   static String Queue2_Key = "2";

    //    队列Queue1 2的死信交换机
    public  static String Dead_Exchange = "Dead_Exchange";
    //    死信队列
    public  static String Dead_Queue = "Dead_Queue";
    //    死信队列路由
    public   static String Dead_Routing = "Dead";

    //    普通交换机的备份交换机 Fanout
    public  static String normal_Exchange_Backup = "normal_Exchange_Backup";
    // 备份交换机的队列
    public  static String backUp_Queue = "BackUp";
    public  static String Warn_Queue = "WARN";
}
