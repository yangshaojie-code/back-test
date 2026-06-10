package com.itheima.test1234.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class updateUser {
    private String nickname;
    private String avatarUrl;
    private String bio;
}
