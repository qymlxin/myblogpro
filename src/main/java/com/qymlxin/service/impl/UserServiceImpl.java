package com.qymlxin.service.impl;


import com.qymlxin.mapper.UserMapper;
import com.qymlxin.pojo.User;
import com.qymlxin.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryUserById(int id) {
        return userMapper.queryUserById(id);
    }

    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }

    public List<User> queryAllUser() {
        return userMapper.queryAllUser();
    }

    public int addUser(User user) {
        //在数据库中查询该数据是否已存在
        User userTemp = userMapper.queryUserByName(user.getUsername());
        if(userTemp != null) {
            //已存在返回-1
            return -1;
        }
        return userMapper.addUser(user);
    }

    public int deleteUserById(int id) {
        return userMapper.deleteUserById(id);
    }

    public int updateUser(User user) {
        User oldUser = userMapper.queryUserById(user.getId());
        User newUser = new User();
        newUser.setId(oldUser.getId());
        newUser.setCreated(oldUser.getCreated());
        if(user.getUsername() == null) {
            newUser.setUsername(oldUser.getUsername());
        } else {
            newUser.setUsername(user.getUsername());
        }

        if(user.getAvatar() == null) {
            newUser.setAvatar(oldUser.getAvatar());
        } else {
            newUser.setAvatar(user.getAvatar());
        }

        if(user.getEmail() == null) {
            newUser.setEmail(oldUser.getEmail());
        } else {
            newUser.setEmail(user.getEmail());
        }

        if(user.getPassword() == null) {
            newUser.setPassword(oldUser.getPassword());
        } else {
            newUser.setPassword(user.getPassword());
        }

        if(user.getStatus() == 0) {
            newUser.setStatus(oldUser.getStatus());
        } else {
            newUser.setStatus(user.getStatus());
        }

        if(user.getLastLogin() == null) {
            newUser.setLastLogin(oldUser.getLastLogin());
        } else {
            newUser.setLastLogin(user.getLastLogin());
        }

        return userMapper.updateUser(newUser);
    }
}
