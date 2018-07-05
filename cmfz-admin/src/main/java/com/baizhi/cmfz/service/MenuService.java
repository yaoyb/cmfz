package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
public interface MenuService {

   public List<Menu> queryAllFirst();

   public List<Menu> querySecond(String id);
}
