package com.lanou.controller;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/8/22.
 */
@Controller
public class MainController {

    @Resource
    private MessageService service;

    @RequestMapping(value = "/")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<Message> findAllMsg(){
        List<Message> message =  service.findAllMsg();
        return message;
    }

    @RequestMapping(value = "/pagetest")
    @ResponseBody
    public PageInfo<Message> pagetest(){
        return service.queryPage(1,2);
    }

    @RequestMapping(value = "/test")
    @ResponseBody
    public String gittest(){
        return "bbb";
    }

    public void test02(){
        System.out.println("hahaha");
    }





    //编辑代码

    @RequestMapping(value = "/branch")
    public String branchTest(){
        return "branch";
    }


}
