package com.qk.order.controller;

import com.qk.order.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * Feign客户端控制器
 *
 * @author yd
 * @create 2019-03-10 22:33
 */
@RestController
@Slf4j
public class FeignClientroller {

    @Autowired
    private UserClient userClient;

    @GetMapping("/getUserMsg")
    public String getUserMsg(){
        String userMsg = userClient.userMsg();
        log.info("userMsg:{}", userMsg);
        return userMsg;
    }

}
