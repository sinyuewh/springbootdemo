package com.exsun.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    //使用Spring 的日志类
    private static final Logger logger= LoggerFactory.getLogger(HttpAspect.class);
    /**
     * 公共的切入点方法
     */
    @Pointcut("execution(public * com.exsun.girl.Controller.GirlController.*(..))")
    public void pointcut(){ }

    /**
     * 执行方法前拦截
     */
    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint)
    {
        //得到Request请求
        ServletRequestAttributes attributest=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributest.getRequest();

        //url
        logger.info("url={}",request.getRequestURI());

        //method
        logger.info("method={}",request.getMethod());

        //ip
        logger.info("ip={}",request.getRemoteAddr());

        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

        //参数
        logger.info("argus={}",joinPoint.getArgs());
    }


    /**
     * 执行方法后拦截
     */
    @After("pointcut()")
    public void doAfter()
    {
        logger.info("22222222");
    }

    /**
     * 记录返回的参数
     * @param object
     */
    @AfterReturning( returning = "object",pointcut = "pointcut()")
    public void doAfterReturn(Object object)
    {
        logger.info("response={}",object);
    }
}
