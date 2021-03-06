package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
//@Component(value = "userService")
public class UserService {

    public void say(){
        System.out.println("userService执行了。");
        System.out.println(name);
    }

//    @Autowired
//    @Qualifier("userDao")
    @Resource(name = "userDao")
    private UserDao userDao;

    public void add(){
        userDao.add();
    }

    @Value("123")
    private String name;

}
