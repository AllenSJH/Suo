package com.lanou.service;

import com.github.pagehelper.PageInfo;
import com.lanou.bean.Message;

import java.util.List;

/**
 * Created by dllo on 17/8/22.
 */
public interface MessageService {

    List<Message> findAllMsg();

    PageInfo<Message> queryPage(Integer pagenum,Integer pageSize);


}
