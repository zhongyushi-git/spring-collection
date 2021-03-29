package com.zxh.controller;

import com.zxh.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @PostMapping("/login")
    public Map login(@RequestBody User user, HttpServletRequest request) {
        Map map = new HashMap();
        if ("admin".equals(user.getUsername()) && "1234".equals(user.getUsername())) {
            //设置session
            HttpSession session = request.getSession();
            session.setAttribute("username", user.getUsername());
            map.put("msg", "登录成功");
            map.put("status", true);
        } else {
            map.put("msg", "用户名或密码错误");
            map.put("status", false);
        }
        return map;
    }
}
