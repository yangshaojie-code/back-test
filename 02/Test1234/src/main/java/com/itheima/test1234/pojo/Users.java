package com.itheima.test1234.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    private Integer id;
    private String username;
    private String password;
    private  String email;
    private String nickname;
    private String avatarUrl;
    private String bio;
    boolean isActive;
    LocalDateTime createAt;
    LocalDateTime updateAt;
}
