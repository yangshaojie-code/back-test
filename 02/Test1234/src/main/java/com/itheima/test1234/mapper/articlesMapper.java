package com.itheima.test1234.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface articlesMapper {
    @Update("update test1234.articles set title = #{title}, content = #{content}")
    public void updateArticle(String title, String content);

    @Delete("delete from test1234.articles where id =#{id}")
    public void delete(String id);
}
