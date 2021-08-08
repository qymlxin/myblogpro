package com.qymlxin.service;

import com.qymlxin.mapper.UserMapper;
import com.qymlxin.pojo.User;

import java.util.List;

public interface UserService {

    public User queryUserById(int id);
    public User queryUserByName(String username);
    public List<User> queryAllUser();
    public int addUser(User user);
    public int deleteUserById(int id);
    public int updateUser(User user);
}
