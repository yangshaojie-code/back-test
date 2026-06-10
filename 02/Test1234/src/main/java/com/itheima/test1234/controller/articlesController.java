package com.itheima.test1234.controller;

import com.itheima.test1234.pojo.Result;
import com.itheima.test1234.service.articlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class articlesController {

    @Autowired
    private articlesService articlesService;

//    @PostMapping("/api/articles")
//    public Result addArticles(@RequestParam String title,  @RequestParam String content) {
//        articlesService.addArticles(title, content);
//        return Result.success();
//    }
    @PutMapping("/api/articles/{id}")
    public Result updateArticle(String title, String content){
        articlesService.updateArticle(title,content);
        return Result.success();
    }

    @DeleteMapping("/api/articles/{id}")
    public Result delete(String id){
        articlesService.delete(id);
        return Result.success();
    }


}
