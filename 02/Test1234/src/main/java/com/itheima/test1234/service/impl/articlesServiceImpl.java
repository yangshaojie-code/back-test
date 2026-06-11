package com.itheima.test1234.service.impl;

import com.itheima.test1234.mapper.articlesMapper;
import com.itheima.test1234.service.articlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class articlesServiceImpl implements articlesService {

    @Autowired
    private articlesMapper articlesMapper;
    @Override
    public void updateArticle(String title, String content) {
        articlesMapper.updateArticle(title,content);
    }

    @Override
    public void delete(String id) {
        articlesMapper.delete(id);
    }
}
