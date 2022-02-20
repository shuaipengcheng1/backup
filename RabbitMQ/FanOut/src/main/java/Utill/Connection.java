package Utill;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConnectionFactory;

public class Connection {
    public static Channel GetChannle() throws Exception{
//        获取链接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername("misaka");
        connectionFactory.setHost("192.168.194.128");
        connectionFactory.setPassword("spc652324");
        com.rabbitmq.client.Connection connection= connectionFactory.newConnection();
        return connection.createChannel();
    }
}
