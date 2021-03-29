package com.zxh.controller;

import com.zxh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//@Controller
@RestController
public class HelloController2 {

//    @RequestMapping("/hello2")
//    public ModelAndView hello() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("test");
//        return modelAndView;
//    }

    //    @ResponseBody
    @RequestMapping(value = "/hello3", produces = "text/html;charset=UTF-8")
    public String hello3() {
        return "你好啊，ResponseBody";
    }

    //    @ResponseBody
    @RequestMapping(value = "/hello4")
    @GetMapping
    public User hello4() {
        User user = new User();
        user.setPassword("123");
        user.setUsername("傻子");
        return user;
    }
}
