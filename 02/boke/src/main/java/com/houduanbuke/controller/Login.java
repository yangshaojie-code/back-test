package com.houduanbuke.controller;

import com.houduanbuke.Service.UserService;
import com.houduanbuke.Tool.JWTTool;
import com.houduanbuke.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import javax.xml.transform.Result;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class Login {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(User user) {
      User who=userService.selectUserByUsername(user.getUsername(),user.getPassword_hash())
              if(who==null){
                  return Result.error("密码或用户名错误");
              }
        Map<String,Object> claims=new HashMap<>();
              claims.put("name",user.getUsername());
              claims.put("password",user.getPassword_hash());
              String jwt= JWTTool.generateJwt(claims);
              return Result.success(jwt);
    }
}
