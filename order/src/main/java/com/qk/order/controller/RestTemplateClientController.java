package com.qk.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 描述:
 * 测试客户端控制器
 * @author yd
 * @create 2019-03-10 21:54
 */
@RestController
@Slf4j
public class RestTemplateClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getUserMsg1")
    public String getUserMsg1(){
        /**
         * 第一种方式RestTemplate
         *     缺陷：
         *    1.url是写死的
         *    2.服务提供方可能是分布式的多节点应用
         */
        RestTemplate template = new RestTemplate();
        String result = template.getForObject("http://localhost:8085/msg", String.class);
        log.info("result:{}", result);
        return result;
    }

    @GetMapping("/getUserMsg2")
    public String getUserMsg2(){
        /**
         * 第二种方式LoadBalancerClient
         *     缺陷：开发不够便捷，拓展性差
         */
        RestTemplate template = new RestTemplate();
        ServiceInstance serviceInstance = loadBalancerClient.choose("USER");
        String url = String.format("http://%s:%s/%s", serviceInstance.getHost(), serviceInstance.getPort(), "msg");
        String result = template.getForObject(url, String.class);
        log.info("url:{}", url);
        log.info("result2:{}", result);
        return result;
    }

    @GetMapping("/getUserMsg3")
    public String getUserMsg3(){
        /**
         * 第三种方式通过配置注解
         *     缺陷：
         *    1.url是写死的
         *    2.服务提供方可能是分布式的多节点应用
         */
        String result = restTemplate.getForObject("http://USER/msg", String.class);
        log.info("result3:{}", result);
        return result;
    }

}
