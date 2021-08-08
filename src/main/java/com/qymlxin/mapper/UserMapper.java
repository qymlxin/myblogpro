package com.qymlxin.mapper;

import com.qymlxin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    public User queryUserById(@Param("id") int id);
    public User queryUserByName(@Param("username") String username);
    public List<User> queryAllUser();
    public int addUser(User user);
    public int deleteUserById(int id);
    public int updateUser(User user);
}