package com.qk.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述:
 * 测试服务端控制器
 * @author yd
 * @create 2019-03-10 21:56
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg(){
        return "response from user service! ok!";
    }

}
