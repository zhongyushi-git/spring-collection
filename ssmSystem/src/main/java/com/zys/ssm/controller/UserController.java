package com.zys.ssm.controller;

import com.zys.ssm.entity.ResultCommon;
import com.zys.ssm.entity.User;
import com.zys.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/getOneById/{id}")
    public ResultCommon getOneById(@PathVariable("id")String id){
        User user = userService.getOneById(id);
        return new ResultCommon(200,"操作成功",user);
    }

    /**
     * 获取列表，分页
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getList")
    public ResultCommon getList(int page,int limit){
        List<User> userList = userService.getList(page,limit);
        int total = userService.getCount();
        return new ResultCommon(200,"操作成功",userList,total);
    }


    /**
     * 根据传递的数组删除
     * @param arr
     * @return
     */
    @DeleteMapping("/delByArr/{arr}")
    public ResultCommon delByArr(@PathVariable("arr")String arr){
        int count = userService.delByArr(arr);
        if(count!=0){
            return new ResultCommon(200,"操作成功");
        }else{
            return new ResultCommon(456,"操作失败");
        }

    }

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping("/create")
    public ResultCommon create(@RequestBody User user){
        int count = userService.create(user);
        if(count!=0){
            return new ResultCommon(200,"操作成功");
        }else{
            return new ResultCommon(456,"操作失败");
        }
    }

    /**
     * 修改
     * @param user
     * @return
     */
    @PostMapping("/update")
    public ResultCommon update(@RequestBody User user){
        int count = userService.update(user);
        if(count!=0){
            return new ResultCommon(200,"操作成功");
        }else{
            return new ResultCommon(456,"操作失败");
        }
    }


}
