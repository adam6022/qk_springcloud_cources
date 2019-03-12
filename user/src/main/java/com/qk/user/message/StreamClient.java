package com.qk.user.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 11:11
 */
public interface StreamClient {

    // 接收消息、入口
    @Input("myMessageInput")
    SubscribableChannel input();

    // 发送消息、
    @Output("myMessageOutput")
    MessageChannel output();
}
