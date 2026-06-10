package com.houduanbuke.Service;

import com.houduanbuke.pojo.User;

import java.lang.management.LockInfo;

public interface UserService {

    public User selectUserByUsername(String username,String password);

}

