package Custom;

import Utill.Connection;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

public class Custom1 {
    public static String MQ_NAME="1";

    public static void main(String[] args) throws Exception {
      Channel channel= Connection.GetChannle();
      channel.queueDeclare(MQ_NAME,true,false,false,null);
        DeliverCallback deliverCallback =(Tag,Message)->{
            System.out.println(new String(Message.getBody()));
            channel.basicAck(Message.getEnvelope().getDeliveryTag(),false);
        };
        CancelCallback cancelCallback =(tag)->{
            System.out.println(tag);
        };
      //      获取信息
        channel.basicConsume(MQ_NAME,false,deliverCallback,cancelCallback);
    }
}
