package com.qk.user.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 09:38
 */
@Slf4j
@Component
public class MqReceiver {

    @RabbitListener(queuesToDeclare = @Queue("MyQueue"))
    public void  process(String message){
        log.info("MqReceiver:{}", message);
    }

}
