package com.liff.blog.service;

import com.liff.blog.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findUserById(int userid);

    public User findUserByName(String username);

    public User findUserByEmail(String email);

    public int addUser(User user);

    public int updateUser(User user);

    public int deleteUser(int userid);

}
