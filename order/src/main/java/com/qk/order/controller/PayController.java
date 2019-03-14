package com.qk.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 支付控制器
 * @author yd
 * @create 2019-03-13 21:23
 */
@RestController
@Slf4j
public class PayController {

    @PostMapping("/doPay")
    public String doPay(String money){
        log.info("用户已支付订单，金额为：{}", money);
        return "用户已支付订单，金额为：" + money;
    }
}
