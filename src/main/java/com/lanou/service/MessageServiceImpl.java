package com.lanou.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;
import com.lanou.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/8/22.
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Resource
   private MessageMapper mapper;


    public List<Message> findAllMsg() {
        return mapper.findAllMsg();
    }

    public PageInfo<Message> queryPage(Integer pagenum, Integer pageSize) {

        pagenum = pagenum == null?1:pagenum;
        pageSize = pageSize == null?5:pagenum;

        PageHelper.startPage(pagenum,pageSize);
        List<Message> list =  mapper.findAllMsg();

        //使用PageInfo 对查询结果进行包装
        PageInfo<Message> pageInfo = new PageInfo<Message>(list);

        return pageInfo;
    }
}
