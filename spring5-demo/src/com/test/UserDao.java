package com.test;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void add(){
        System.out.println("我是userDao的add方法");
    }
}
