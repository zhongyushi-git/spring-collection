package com.zys.ssm.service.impl;

import com.zys.ssm.entity.User;
import com.zys.ssm.dao.UserDao;
import com.zys.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getOneById(String id) {
        return userDao.getOneById(id);
    }

    public List<User> getList(int page, int limit) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", (page - 1) * limit);
        map.put("limit", limit);
        return userDao.getList(map);
    }

    public int getCount() {
        return userDao.getCount();
    }

    public int update(User user) {
        return userDao.update(user);
    }

    public int delByArr(String arr) {
        List<String> list = new ArrayList<String>();
        String[] split = arr.split(",");
        for (String s : split) {
            list.add(s);
        }
        return userDao.delByArr(list);
    }

    public int create(User user) {
        return userDao.create(user);
    }
}
