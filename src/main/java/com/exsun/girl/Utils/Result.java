package com.exsun.girl.Utils;

/**
 * Http 返回的结果表示
 * @param <T>
 */
public class Result<T> {

    //错误码
    private Integer code;

    //错误提示
    private String msg;

    //返回的结果
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
