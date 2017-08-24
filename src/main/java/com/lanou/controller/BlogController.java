package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Blog;
import com.lanou.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/8/23.
 */
@Controller
public class BlogController {

    @Resource
    private BlogService blogService;

    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/newblog")
    public String newBlog(){
        return "newblog";
    }


    @RequestMapping(value = "/add")
    public String addBlog(Blog blog){
      blogService.addBlog(blog);
      return "index";
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Blog> findAllBlog(){

       List<Blog> blog =  blogService.findAllBlog();
       return blog;
    }

    @RequestMapping(value = "/pagetest")
    @ResponseBody
    public PageInfo<Blog> pagetest(){
        return blogService.queryPage(1,2);
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public Integer deleteBlog(@RequestParam("bid") int bid){
      Integer blogid = blogService.deleteBlog(bid);
       return blogid;
    }



}
