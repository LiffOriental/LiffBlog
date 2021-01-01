package com.liff.blog.mapper;

import com.liff.blog.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUser();
    @Select("select * from user where userid = #{userid}")
    User findUserById(int userid);
    @Select("select * from user where username=#{username}")
    User findeUserByName(String username);
    @Insert("insert into user(userid,username,password,email,role,userimg,registrationtime)values(#{userid},#{username},#{password},#{email},#{role},#{userimg},#{registrationtime})")
    int addUser(User user);
    @Delete("delete from user where userid=#{userid}")
    int deleteUser(int userid);
    @Update("update user set username=#{username},password=#{password},email=#{email},role=#{role},userimg=#{userimg},registrationtime=#{registrationtime} where userid=#{userid}")
    int updateUser(User user);

}
