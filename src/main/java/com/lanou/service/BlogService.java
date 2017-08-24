package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Blog;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dllo on 17/8/23.
 */
public interface BlogService {


    void addBlog(Blog blog);

    List<Blog> findAllBlog();

    PageInfo<Blog> queryPage(Integer pagenum,Integer pageSize);

    Integer deleteBlog(int bid);

}
