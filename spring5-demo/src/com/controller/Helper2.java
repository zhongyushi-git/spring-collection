package com.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Helper2 {

    @Before(value = "execution(* com.controller.StuDao2.add(..))")
    public void before() {
        System.out.println("before方法");
    }

    @After(value = "execution(* com.controller.StuDao2.add(..))")
    public void after() {
        System.out.println("after方法");
    }

    //后置通知
    @AfterReturning(value = "execution(* com.controller.StuDao2.add(..))", returning = "value")
    public void afterReturn(JoinPoint jp, Object value) {
        System.out.println("后置通知的返回值是" + value);
    }

    //环绕通知
    @Around(value = "execution(* com.controller.StuDao2.add(..))")
    public Object around(ProceedingJoinPoint jp) throws Throwable {
        Object o = jp.proceed();
        return o;
    }


    //异常通知
    @AfterThrowing(value = "execution(* com.controller.StuDao2.add(..))", throwing = "e")
    public void afterThrow(Throwable e) {
        System.out.println(e);
    }
}
