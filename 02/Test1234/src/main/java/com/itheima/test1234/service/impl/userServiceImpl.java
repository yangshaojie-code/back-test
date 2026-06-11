package com.itheima.test1234.service.impl;

import com.itheima.test1234.mapper.userMapper;
import com.itheima.test1234.pojo.Users;
import com.itheima.test1234.service.userService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userMapper userMapper;

    @Override
    public void updateUser(String nickname, String avatarUrl, String bio) {
        Users user = new Users();
        user.setNickname(nickname);
        user.setAvatarUrl(avatarUrl);
        user.setBio(bio);
        userMapper.updateUser(user.getNickname(),user.getAvatarUrl(),user.getBio());
    }

    @Override
    public void updatePassword(String oldPassword, String newPassword) {

    }

    @Override
    public Users getUser(String id) {
        return userMapper.getUser(id);

    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
