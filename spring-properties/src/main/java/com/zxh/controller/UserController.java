package com.zxh.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${name}")
    private String name1;

    @Value("${app.name}")
    private String name2;

    @Value("${china_name}")
    private String chinaName;

    @Value("#{configProperties.name}")
    private String name3;

    @Value("#{configProperties['app.name']}")
    private String name4;

    @GetMapping("/get1")
    public JSONObject get1() {
        JSONObject json = new JSONObject();
        json.put("data", name1);
        return json;
    }

    @GetMapping("/get2")
    public JSONObject get2() {
        JSONObject json = new JSONObject();
        json.put("data", name2);
        return json;
    }

    @GetMapping("/get3")
    public JSONObject get3() {
        JSONObject json = new JSONObject();
        json.put("data", chinaName);
        return json;
    }

    @GetMapping("/get4")
    public JSONObject get4() {
        JSONObject json = new JSONObject();
        json.put("data", name3);
        return json;
    }

    @GetMapping("/get5")
    public JSONObject get5() {
        JSONObject json = new JSONObject();
        json.put("data", name4);
        return json;
    }

}
