package com.qk.user.service.impl;

import com.qk.user.model.User;
import com.qk.user.repository.UserRepository;
import com.qk.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


/**
 * 描述:
 * 用户业务实现类
 * @author yd
 * @create 2019-03-10 20:25
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查找一个用户
     *
     * @param id
     * @return
     */
    @Override
    public User findOne(Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    /**
     * 分页查询所有用户
     *
     * @param pageable
     * @return
     */
    @Override
    public Page<User> findAll(Pageable pageable) {
        Page<User> userPage = userRepository.findAll(pageable);
        return userPage;
    }

    /**
     * 保存/更新用户
     *
     * @param user
     * @return
     */
    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
