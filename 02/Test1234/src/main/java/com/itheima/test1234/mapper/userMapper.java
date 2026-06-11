package com.itheima.test1234.mapper;

import com.itheima.test1234.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userMapper {
    @Update("update test1234.users set nickname = #{nickname}, avatar_url = #{avataUrl}, bio = #{bio}")
    public void updateUser(String nickname, String avatarUrl, String bio);

    @Select("select * from test1234.users where id = #{id}")
    public Users getUser(String id);

    public
}
