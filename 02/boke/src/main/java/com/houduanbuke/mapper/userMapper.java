package com.houduanbuke.mapper;

import com.houduanbuke.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {

     List<User> register(
            String username,
            String email,
            String password,
            String nickname
    );

     List<User> findAll();

}
