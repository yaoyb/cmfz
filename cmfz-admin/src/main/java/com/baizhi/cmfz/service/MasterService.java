package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/6.
 */
public interface MasterService {
    public List<Master> queryAll(int nowPage,int pageSize);

    public List<Master> queryByName(int nowPage,int pageSize,String name);

    public int modify(Master master);

    public int add(Master master);
}
