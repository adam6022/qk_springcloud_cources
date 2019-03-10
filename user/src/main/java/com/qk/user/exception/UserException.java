package com.qk.user.exception;

/**
 * 描述:
 *用户异常类
 * @author yd
 * @create 2019-03-10 21:29
 */
public class UserException extends RuntimeException{

    private Integer code;

    public UserException(Integer code, String msg){
        super(msg);
        this.code = code;
    }

}
