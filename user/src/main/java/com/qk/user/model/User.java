package com.qk.user.model;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * 描述:
 * 用户数据模型
 * @author yd
 * @create 2019-03-10 19:48
 */
@Data
@DynamicUpdate
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String homeUrl;

    private String screenName;

    private Integer created;

    private Integer activated;

    private Integer logged;

    private String groupName;

    private String telnumber;

    private Date ctime;

    private Date mtime;

}
