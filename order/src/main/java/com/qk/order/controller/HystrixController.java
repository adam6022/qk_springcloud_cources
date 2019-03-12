package com.qk.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.qk.order.client.UserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 描述:
 *
 * @author yd
 * @create 2019-03-12 16:06
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    @Autowired
    private UserClient userClient;

    /**
     * 通过@HystrixCommand注解指定可降级的服务，fallbackMethod参数指向的是回调函数，函数名称可自定义
     *
     * @return String
     */
    @HystrixCommand(
            commandProperties = {
                    // 设置超时时间为3秒
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
            }
    )
    @GetMapping("/hystrix/getUserMsg")
    public String getMsg() throws InterruptedException {
        String userMsg = userClient.userMsg();
        Thread.sleep(5000);
        return userMsg;
    }



    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), // 开启熔断机制
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 设置当请求失败的数量达到10个后，打开断路器，默认值为20
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 设置打开断路器多久以后开始尝试恢复，默认为5s
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 设置出错百分比阈值，当达到此阈值后，打开断路器，默认50%
    })
    @GetMapping("/hystrix/getUserMsg2")
    public String getUserMsg(@RequestParam("number") Integer number) throws InterruptedException {
        if (number % 2 == 0) {
            return "success";
        }
        String userMsg = userClient.userMsg();
        return userMsg;
    }

    /**
     * 触发降级后的回调函数
     *
     * @return String
     */
    public String fallback() {
        return "太拥挤了, 请稍后重试~";
    }

    /**
     * 触发降级后的默认回调函数
     *
     * @return String
     */
    public String defaultFallback() {
        return "默认提示：太拥挤了, 请稍后重试~";
    }

}
