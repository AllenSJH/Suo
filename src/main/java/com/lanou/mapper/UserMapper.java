package com.lanou.mapper;

import com.lanou.bean.Blog;
import com.lanou.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dllo on 17/8/23.
 */
public interface UserMapper {


    List<Blog> findAllMessage();

    User loginBlog(@Param("name") String name,
                   @Param("password") String password);

    void regiest(User user);

}
