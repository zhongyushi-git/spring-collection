package com.zys.ssm.service;


import com.zys.ssm.entity.User;

import java.util.List;

public interface UserService {
    public User getOneById(String id);

    int create(User user);

    int delByArr(String arr);

    List<User> getList(int page, int limit);

    int getCount();

    int update(User user);
}
