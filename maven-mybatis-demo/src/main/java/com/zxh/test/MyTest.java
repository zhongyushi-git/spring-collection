package com.zxh.test;

import com.zxh.dao.UserDao;
import com.zxh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyTest {
    @Test
    public void findAll() throws IOException {
        //加载核心配置文件
        Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
        //创建SessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        //创建一个session对象
        SqlSession session = build.openSession();

        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> list = userMapper.findAll();
        System.out.println(list);
    }
}
