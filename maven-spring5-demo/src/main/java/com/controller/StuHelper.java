package com.controller;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class StuHelper implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("我是增强类的before方法");
    }
}
