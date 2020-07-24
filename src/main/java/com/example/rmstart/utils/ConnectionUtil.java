package com.example.rmstart.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 工具类
 * @Author: zhouhongzhan
 * @Date: 2020/7/25 1:46
 */
public class ConnectionUtil {

    /**
     * 建立与RabbitMQ的连接
     **/
    public static Connection getConnection() throws IOException, TimeoutException {
        // 定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 设置服务器地址
        factory.setHost("localhost");
        // 端口
        factory.setPort(5672);
        // 设置用户名、密码、主机
//        factory.setVirtualHost();
//        factory.setUsername();
//        factory.setPassword();
        // 获取连接
        Connection connection = factory.newConnection();
        return connection;
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
