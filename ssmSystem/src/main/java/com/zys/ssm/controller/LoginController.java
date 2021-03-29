package com.zys.ssm.controller;

import com.zys.ssm.entity.ResultCommon;
import com.zys.ssm.entity.User;
import com.zys.ssm.service.LoginService;
import com.zys.ssm.util.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResultCommon login(String id, String password) {
//        user.setPassword(Md5Utils.md5(user.getPassword()));
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        User login = loginService.login(user);
        if (login != null) {
            return new ResultCommon(200, "操作成功");
        } else {
            return new ResultCommon(456, "登录失败");
        }
    }
}
