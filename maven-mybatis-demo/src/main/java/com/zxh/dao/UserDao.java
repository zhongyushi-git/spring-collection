package com.zxh.dao;

import com.zxh.entity.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
  }
