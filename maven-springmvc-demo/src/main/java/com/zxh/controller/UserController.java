package com.zxh.controller;

import com.zxh.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Valid @RequestBody User user, BindingResult errors) {
        //是否验证不通过
        if (errors.hasErrors()) {
            List<ObjectError> allErrors = errors.getAllErrors();
            for (ObjectError err : allErrors) {
                System.out.println(err);
            }
        } else {
            System.out.println(user);
        }
    }

    @RequestMapping("/get")
    public void get(@RequestParam(value = "id") int ids) {
        System.out.println(ids);
    }

    @RequestMapping("/get2")
    public void get2(String username, String password) {
        System.out.println(username + " " + password);
    }


    @RequestMapping("/login")
    public String login1(){
        return "forward:views/login.jsp";
    }

    @RequestMapping("/login2")
    public String login2(){
        return "redirect:views/login.jsp";
    }

    @RequestMapping("login3")
    public String login3(){
        return "login";
    }
}
