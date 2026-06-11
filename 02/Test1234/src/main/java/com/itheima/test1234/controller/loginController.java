package com.itheima.test1234.controller;

import com.itheima.test1234.pojo.Result;
import com.itheima.test1234.pojo.Users;
import com.itheima.test1234.service.userService;
import com.itheima.test1234.utils.JwtUtils;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class loginController
{
    @Autowired
    private userService userService;

    @PostMapping("/api/auth/login")
    public Result login(Users u)
    {
        User user = userService.login(u);
        if (user != null)
        {
            HashMap<String,Object> map = new HashMap<>();
            map.put("id",u.getId());
            map.put("username",u.getUsername());
            map.put("password",u.getPassword());
            String jwt = JwtUtils.generateJwt(map);
            return Result.success(jwt);
        }
        return Result.error();
    }
}
