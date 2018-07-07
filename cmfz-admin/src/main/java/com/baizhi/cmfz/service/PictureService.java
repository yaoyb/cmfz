package com.baizhi.cmfz.service;


import com.baizhi.cmfz.entity.Picture;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
public interface PictureService {

    public List<Picture> queryAll(int nowPage,int pageSize);

    public Integer queryTotal();

    public int remove(String id);

    public int modify(Picture picture);

    public int add(Picture picture);

}
