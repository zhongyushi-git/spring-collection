package com.zxh.dao;

import com.zxh.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();

    User findById(Integer id);

    User findByNmAndPwd(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    List<User> findByLikeOne(String username);

    List<User> findByLikeMore(User user);
}
