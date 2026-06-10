package com.houduanbuke.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
    private BigInteger id;
    private BigInteger user_id;
    private String title;
    private int is_deleted;
    private BigInteger views_count;
    private Data created_at;
    private Data updated_at;
}
