package com.itheima.test1234.service;

import com.itheima.test1234.pojo.Users;
import org.apache.catalina.User;

public interface userService {
    public void updateUser(String nickname, String avatarUrl, String bio);
    public void updatePassword(String oldPassword, String newPassword);
    public Users getUser(String id);
    public User login(User user);
}
