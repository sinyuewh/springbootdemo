package com.exsun.girl.Handle;

//RuntimeException 支持事务回滚
/**
 * 自定义的异常类
 * 作者：金寿吉
 */
public class MyException extends RuntimeException {
    private  Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MyException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }
}
