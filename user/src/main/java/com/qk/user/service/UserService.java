package com.qk.user.service;

import com.qk.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
 * 描述:
 * 用户业务接口
 * @author yd
 * @create 2019-03-10 20:21
 */
public interface UserService {

    /**
     * 查找一个用户
     * @param id
     * @return
     */
    User findOne(Integer id);

    /**
     * 分页查询所有用户
     * @param pageable
     * @return
     */
    Page<User> findAll(Pageable pageable);

    /**
     * 保存/更新用户
     * @param user
     * @return
     */
    User save(User user);

}
