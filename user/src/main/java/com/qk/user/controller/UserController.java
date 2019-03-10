package com.qk.user.controller;

import com.qk.user.exception.UserException;
import com.qk.user.model.User;
import com.qk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 * 用户控制层
 * @author yd
 * @create 2019-03-10 20:54
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findAll")
    public Page<User> findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "size", defaultValue = "5") Integer size){
        Pageable pageable = PageRequest.of(page - 1,size);
        return userService.findAll(pageable);
    }

    @GetMapping("/{id:\\d+}")
    public User findOne(@PathVariable Integer id){
        User user = userService.findOne(id);
        if (user != null){
            throw new UserException(1, "用户不存在");
        }
        return user;
    }
}
