package com.qk.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * 描述:
 * 发送mq消息测试
 * @author yd
 * @create 2019-03-12 09:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSenderTest extends UserApplicationTests{

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void Send(){
        amqpTemplate.convertAndSend("MyQueue", "now" + new Date());
    }

}
