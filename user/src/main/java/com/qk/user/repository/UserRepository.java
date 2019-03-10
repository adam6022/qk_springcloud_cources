package com.qk.user.repository;

import com.qk.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述:
 * 用户数据层
 *
 * @author yd
 * @create 2019-03-10 19:53
 */
public interface UserRepository extends JpaRepository<User, Integer> {
}
