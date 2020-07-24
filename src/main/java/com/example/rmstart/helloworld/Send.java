package com.example.rmstart.helloworld;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description:
 * @Author: zhouhongzhan
 * @Date: 2020/7/25 1:13
 */
public class Send {

    private final static String QUEUE_NAME = "hello rabbitMQ";

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        // 获取连接
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "HEllo World!";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println(" [x] Sent:" + message + "");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
