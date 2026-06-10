package com.itheima.test1234.controller;

import com.itheima.test1234.pojo.Result;
import com.itheima.test1234.pojo.Users;
import com.itheima.test1234.pojo.updateUser;
import com.itheima.test1234.service.userService;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class userController {

    @Autowired
    private userService userService;

    @PutMapping("/api/users/me")
    public Result updateUser(String nickname, String avatarUrl, String bio){
        userService.updateUser(nickname,avatarUrl,bio);
        return Result.success();
    }

    @PutMapping("/api/users/me/password")
    public Result updatePassword(String oldPassword, String newPassword){
        userService.updatePassword(oldPassword,newPassword);
        return Result.success();
    }

    @GetMapping("api/users/{id}")
    public Result getUser(String id){
        Users user = userService.getUser(id);
        return Result.success(user);
    }
}
