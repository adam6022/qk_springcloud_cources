package com.qk.user.controller;

import com.qk.user.message.StreamClient;
import com.qk.user.model.User;
import com.qk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 11:25
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @Autowired
    private UserService userService;

    @GetMapping("/sendMsg")
    public void process(){
        streamClient.output().send(MessageBuilder.withPayload("now:"+ new Date()).build());
    }

    /**
     * 发送User对象
     */
    @GetMapping("/sendUserMsg")
    public void send() {
        User user = userService.findOne(1);
        MessageBuilder<User> messageBuilder = MessageBuilder.withPayload(user);
        streamClient.output().send(messageBuilder.build());
    }

}
