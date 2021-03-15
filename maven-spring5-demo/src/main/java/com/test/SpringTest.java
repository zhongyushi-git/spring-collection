package com.test;

import com.entity.*;
import com.test.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    public void helloTest() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象，其中hello就在xml中指定的id值
        Hello hello = context.getBean("hello", Hello.class);
//        Hello hello = (Hello)context.getBean("hello");
        //调用方法
        hello.say();
    }

    @Test
    public void test1() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        User user = (User) context.getBean("user");
        //调用方法
        System.out.println(user.toString());
    }

    @Test
    public void test2() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        User2 user = (User2) context.getBean("user2");
        //调用方法
        System.out.println(user.toString());
    }

    @Test
    public void test3() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        Car car = (Car) context.getBean("car");
        //调用方法
        System.out.println(car);
    }

    @Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coll coll = (Coll) context.getBean("coll");
        System.out.println(coll);
    }

    @Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coll2 coll = (Coll2) context.getBean("coll2");
        System.out.println(coll);
    }

    @Test
    public void test6() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        Car car = (Car) context.getBean("car2");
        //调用方法
        System.out.println(car);
    }

    @Test
    public void test7() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //获取bean对象
        UserService userService = context.getBean("userService", UserService.class);
        //调用方法
        userService.say();
    }

    @Test
    public void test8() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //获取bean对象
        UserService userService = context.getBean("userService", UserService.class);
        //调用方法
        userService.add();
    }

    @Test
    public void test9() {
        //加载配置类
        ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean对象
        UserService userService = context.getBean("userService", UserService.class);
        //调用方法
        userService.add();
    }


}
