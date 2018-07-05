package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
public interface MenuDao {
    public List<Menu> selectAllFirst();

    public List<Menu> selectSecond(String id);

}
