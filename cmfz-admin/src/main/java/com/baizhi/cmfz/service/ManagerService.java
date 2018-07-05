package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 *  @Description ManagerService接口
 * Created by 姚亚博 on 2018/7/4.
 */
public interface ManagerService {
    public Manager queryOne(String mgr_name,String mgr_pwd);
}
