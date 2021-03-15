package com.zxh.test;

import com.zxh.dao.UserDao;
import com.zxh.entity.PVo;
import com.zxh.entity.People;
import com.zxh.entity.Person;
import com.zxh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class MyTest {

    //创建日志对象
    Logger logger = Logger.getLogger(MyTest.class);

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
    public void findAll() throws IOException {
        //加载核心配置文件
        Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
        //创建SessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(reader);
        //创建一个session对象
        SqlSession session = build.openSession();

        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> list = userMapper.findAll();
        logger.info("我是日志信息");
        System.out.println(list);
    }

    @Test
    public void findById() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    @Test
    public void findByNmAndPwd() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("123");
        User user2 = userMapper.findByNmAndPwd(user);
        System.out.println(user2);
    }

    @Test
    public void addUser() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("方启豪5号");
        user.setPassword("12315");
        int i = userMapper.addUser(user);
        session.commit();//提交事务
        System.out.println(i);
    }

    @Test
    public void updateUser() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setId(10);
        user.setUsername("方启豪2号");
        user.setPassword("123");
        userMapper.updateUser(user);
        session.commit();
    }

    @Test
    public void deleteUser() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        userMapper.deleteUser(10);
        session.commit();
    }

    @Test
    public void findByLikeOne() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> list = userMapper.findByLikeOne("h");
        System.out.println(list);
    }

    @Test
    public void findByLikeMore() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("h");
        user.setPassword("4");
        List<User> list = userMapper.findByLikeMore(user);
        System.out.println(list);
    }

    @Test
    public void addPvo() {
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        PVo pVo = new PVo();
        People people = new People();
        Person person = new Person();
        people.setPassword("admin");
        person.setUsername("zhangSan");
        pVo.setPeople(people);
        pVo.setPerson(person);
        userMapper.addPvo(pVo);
        session.commit();//提交事务
    }

    @Test
    public void findUserAndScore(){
        SqlSession session = build.openSession();
        UserDao userMapper = session.getMapper(UserDao.class);
        List<User> list=userMapper.findUserAndScore();
        System.out.println(list);
    }


}
