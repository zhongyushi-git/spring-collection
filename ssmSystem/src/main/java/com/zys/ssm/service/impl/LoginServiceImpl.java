package com.zys.ssm.service.impl;

import com.zys.ssm.dao.LoginDao;
import com.zys.ssm.entity.User;
import com.zys.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;

    public User login(User user) {
        return loginDao.login(user);
    }
}
