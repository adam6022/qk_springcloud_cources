package com.qk.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述:
 * 需要调用的接口
 * @author yd
 * @create 2019-03-10 22:30
 */
@FeignClient(name = "user")
public interface UserClient {

    @GetMapping("msg")
    String userMsg();

}
