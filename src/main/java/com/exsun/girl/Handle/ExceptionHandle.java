package com.exsun.girl.Handle;

import antlr.Utils;
import com.exsun.girl.Utils.Result;
import com.exsun.girl.Utils.ResultUtil;
import com.mysql.jdbc.util.ResultSetUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理类
 */
@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    //处理Exception的异常
    @ExceptionHandler(value=Exception.class)
    public Result handle(Exception e)
    {
        if(e instanceof MyException)
        {
            MyException e1=(MyException)e;
            return ResultUtil.error(e1.getCode(),e1.getMessage());
        }
        else
        {
            return ResultUtil.error(100,e.getMessage());
        }
    }
}
