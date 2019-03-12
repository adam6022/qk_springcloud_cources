package com.qk.user.message;

import com.qk.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 11:22
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

   /* @StreamListener("myMessageOutput")
    public void process(String message) {
        log.info("message : {}", message);
    }*/

    /**
     * 接收User对象
     * @param message message
     */
    @StreamListener("myMessageOutput")
    @SendTo("myMessageInput")
    public String process(User message) {
        log.info("message : {}", message);
        return "success";
    }

    @StreamListener("myMessageInput")
    public void success(String message) {
        log.info("message : {}", message);
    }

}
