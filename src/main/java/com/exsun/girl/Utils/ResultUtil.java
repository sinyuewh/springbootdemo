package com.exsun.girl.Utils;

public class ResultUtil {

    /**
     * 结果成功的方法
     * @param object
     * @return
     */
    public static Result success(Object object)
    {
        Result r1=new Result();
        r1.setCode(0);
        r1.setMsg("成功");
        r1.setData(object);
        return r1;
    }
    public static Result success()
    {
        return success(null);
    }

    /**
     * 失败的返回方法
     * @param errcode
     * @param msg
     * @return
     */
    public static Result error(int errcode ,String msg)
    {
        Result r1=new Result();
        r1.setCode(errcode);
        r1.setMsg(msg);
        return r1;
    }
}
