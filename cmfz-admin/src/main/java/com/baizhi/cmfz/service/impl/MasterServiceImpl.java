package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/6.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {

    @Autowired
    private MasterDao md;

    @Override
    public List<Master> queryAll(int nowPage, int pageSize) {
        int begin = (nowPage-1)*pageSize;
        return md.selectAll(begin,pageSize);
    }

    @Override
    public List<Master> queryByName(int nowPage, int pageSize, String name) {
        int begin = (nowPage-1)*pageSize;
        String likeName = "%"+name+"%";
        return md.selectByName(begin,pageSize,likeName);
    }

    @Override
    public Integer queryTotal() {
        return md.selectTotal();
    }

    @Override
    public Integer queryTotalByName(String name) {
        String likeName = "%"+name+"%";
        return md.selectTotalByName(name);
    }

    @Override
    public int modify(Master master) {
        return md.updata(master);
    }

    @Override
    public int add(Master master) {
        return md.insert(master);
    }
}
