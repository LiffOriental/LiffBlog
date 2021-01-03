package com.liff.blog.service.impl;

import com.liff.blog.mapper.UserMapper;
import com.liff.blog.pojo.User;
import com.liff.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAllUser();
    }

    @Override
    public User findUserById(int userid) {
        return userMapper.findUserById(userid);
    }

    @Override
    public User findUserByName(String username) {
        return userMapper.findeUserByName(username);
    }

    @Override
    public User findUserByEmail(String email){return userMapper.findeUserByEmail(email);}

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(int userid) {
        return userMapper.deleteUser(userid);
    }
}
