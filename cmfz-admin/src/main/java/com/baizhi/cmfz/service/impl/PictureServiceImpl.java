package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pd;

    @Override
    public List<Picture> queryAll(int nowPage, int pageSize) {
        int begin = (nowPage-1)*pageSize;
        return pd.selectAll(begin,pageSize);
    }

    @Override
    public int remove(String id) {
        return pd.delete(id);
    }

    @Override
    public int modify(Picture picture) {
        return pd.updata(picture);
    }

    @Override
    public int add(Picture picture) {
        return pd.insert(picture);
    }
}
