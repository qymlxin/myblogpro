package com.qymlxin.controller;

import com.qymlxin.common.result.Result;
import com.qymlxin.pojo.User;
import com.qymlxin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/queryById/{id}")
    public Object queryById(@PathVariable("id") int id) {
        User user = userService.queryUserById(id);
        return Result.success(user);
    }

    @RequestMapping("/queryByName/{name}")
    public Object queryByName(@PathVariable("name") String username) {
        User user = userService.queryUserByName(username);
        return Result.success(user);
    }

    @RequestMapping("/queryAll")
    public Object queryAll() {
        List userList = userService.queryAllUser();
        return Result.success(userList);
    }

    @RequestMapping("/addUser")
    public Object addUser(@RequestBody User user) {
        int num = userService.addUser(user);
        return Result.success(new String("成功添加了"+ num +"个用户"));
    }

    @RequestMapping("/deleteUser/{id}")
    public Object deleteUser(@PathVariable("id") int id) {
        int num = userService.deleteUserById(id);
        return Result.success(new String("成功删除了"+ num +"个用户"));
    }

    @RequestMapping("/updateUser")
    public Object updateUser(@RequestBody User user) {
        int num = userService.updateUser(user);
        return Result.success(new String("成功更新了"+ num +"个用户"));
    }
}