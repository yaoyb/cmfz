package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao md;

    @Override
    public List<Menu> queryAllFirst() {
        return md.selectAllFirst();
    }

    @Override
    public List<Menu> querySecond(String id) {
        return md.selectSecond(id);
    }
}
