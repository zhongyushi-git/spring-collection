package com.zxh.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyIntercept implements HandlerInterceptor {
    //preHandle：在Handler执行之前调用
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //请求请求的路径
        String path = httpServletRequest.getRequestURI().substring(httpServletRequest.getContextPath().length());
        HttpSession session = httpServletRequest.getSession();
        System.out.println(session.getAttribute("username"));
//        if (session.getAttribute("username") == null) {
//            httpServletResponse.sendRedirect("/login3");
//            return false;
//        } else {
//            System.out.println("ip:" + httpServletRequest.getRemoteHost() + "url" + httpServletRequest.getRequestURL());
//            return true;
//        }

//        return true代表放行
//        return flase代表拦截

        return true;
    }

    //postHandle：在Handler中方法执行一半时调用（return ModelAndView前），可以更改跳转的视图
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    //afterCompletion：在Handler执行完毕之后调用，可以用于异常的处理
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
