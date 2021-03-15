package com.zxh.test;

import com.zxh.dao.UserDao;
import com.zxh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest2 {


    public SqlSessionFactory build = null;

    //这个在方法加载的时候就会初始化
    @Before
    public void before() {
        Reader reader = null;
        //加载核心配置文件
        try {
            reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
            //创建SessionFactory
            build = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("username", "d");
        List<User> byMap = userMapper.findByMap2(map);
        System.out.println(byMap);
    }

    @Test
    public void test3() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<>();
        List<User> byMap = userMapper.findByMap2(map);
        System.out.println(byMap);
    }

    @Test
    public void test4() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(22);
        List<User> list2 = userMapper.findByIn(list);
        System.out.println(list2);
    }

    @Test
    public void test5() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> list = userMapper.findUserAndScore2();
        System.out.println(list);
    }

    @Test
    public void test6() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = userMapper.findById(2);
        System.out.println(user);
        System.out.println("----------");
        User user2 = userMapper.findById(2);
        System.out.println(user2);
    }

    @Test
    public void test7() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = userMapper.findById(2);
        System.out.println(user);
        User user3 = new User();
        user3.setUsername("方启豪6号");
        user3.setPassword("12315");
        userMapper.addUser(user3);
        session.commit();//提交事务
        System.out.println("----------");
        User user2 = userMapper.findById(2);
        System.out.println(user2);
    }

    @Test
    public void test8() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = userMapper.findByNmAndPwd2("方启豪", "123");
        System.out.println(user);
    }

    @Test
    public void test9() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user3 = new User();
        user3.setId(10);
        user3.setUsername("方启豪7号");
        user3.setPassword("123155151");
        userMapper.updateUser2(user3);
        session.commit();
    }

    @Test
    public void test10(){
        SqlSession session = build.openSession();
        UserDao mapper=session.getMapper(UserDao.class);
        User user=mapper.findById(15);
        System.out.println(user);
    }

}
