package com.qk.user.repository;

import com.qk.user.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOneTest(){
        Optional<User> optionalUser = userRepository.findById(1);
        User user = optionalUser.get();
        Assert.assertNotNull(user);
    }

    @Test
    public void save(){
        //User user = new User();
        User user = userRepository.findById(1).get();
        user.setEmail("hznu@edu.cn");
        User result = userRepository.save(user);
        Assert.assertNotNull(result);
    }

    @Test
    public void findAllTest(){
        PageRequest request = PageRequest.of(1,3);
        Page<User> userPage = userRepository.findAll(request);
        Assert.assertNotEquals(0, userPage.getTotalElements());
    }

}