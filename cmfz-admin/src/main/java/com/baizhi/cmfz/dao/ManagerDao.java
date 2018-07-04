package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;

/**
 * @Description ManagerDao接口
 * Created by 姚亚博 on 2018/7/4.
 */
public interface ManagerDao {
    public Manager selectOne(String mgr_id);
}
