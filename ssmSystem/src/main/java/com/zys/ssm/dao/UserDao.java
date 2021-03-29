package com.zys.ssm.dao;

import com.zys.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    User getOneById(@Param("id") String id);

    int create(User user);

    int delByArr(List<String> list);

    List<User> getList(Map<String,Object> map);

    int getCount();

    int update(User user);
}
