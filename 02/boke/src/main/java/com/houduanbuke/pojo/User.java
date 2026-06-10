package com.houduanbuke.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private BigInteger id;
    private String username;
    private String email;
    private String password_hash;
    private String nickname;
    private String avatar_url;
    private String bio;
    private int is_active;
    private Data last_login;
    private Data created_at;
    private Data updated_at;
}
