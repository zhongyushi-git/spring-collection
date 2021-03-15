package com.zxh.dao;

import com.zxh.entity.PVo;
import com.zxh.entity.Score;
import com.zxh.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);

    User findByNmAndPwd(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> findByLikeOne(String username);

    List<User> findByLikeMore(User user);

    int addPvo(PVo pVo);

    List<User> findUserAndScore();

    List<User> findByMap(Map<String, Object> map);

    List<User> findByMap2(Map<String, Object> map);

    List<User> findByIn(List<Integer> list);

    Score findScore(Integer id);

    List<User> findUserAndScore2();

    //使用注解Param传递参数，引号里面的参数是要使用的参数，如#{username}
    User findByNmAndPwd2(@Param("username") String username, @Param("password") String password);

    //这里参数传的是一个对象
    @Update("update user set username=#{user.username}, password=#{user.password} where id=#{user.id}")
    void updateUser2(@Param("user") User user);

    @Select("select * from user where id=#{id}")
    User findById2(@Param("id") Integer id);
}
