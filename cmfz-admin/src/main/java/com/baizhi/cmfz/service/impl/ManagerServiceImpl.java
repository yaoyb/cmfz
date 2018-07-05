package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 姚亚博 on 2018/7/4.
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao md;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public Manager queryOne(String mgr_name,String mgr_pwd) {
        Manager mgr = md.selectOne(mgr_name);
        if(mgr.getMgr_pwd().equals(mgr_pwd)){
            return mgr;
        }
        return null;
    }
}
