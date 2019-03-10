package com.qk.user.service.impl;

import com.qk.user.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void findOne() {
        User user = userService.findOne(1);
        Assert.assertNotNull(user);
    }

    @Test
    public void findAll() {
        PageRequest request = PageRequest.of(1,3);
        Page<User> userPage = userService.findAll(request);
        Assert.assertNotEquals(0, userPage.getTotalElements());
    }

    @Test
    public void save() {
        User user = new User();
        user.setEmail("qk01@163.com");
        userService.save(user);
    }
}