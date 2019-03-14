package com.qk.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 描述:
 * 订单客户端
 *
 * @author yd
 * @create 2019-03-13 21:27
 */
@FeignClient(name = "order")
public interface OrderClient {

    @PostMapping("/doPay")
    public String doPay(String money);

}
