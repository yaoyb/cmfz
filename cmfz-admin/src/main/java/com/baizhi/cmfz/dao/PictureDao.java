package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
public interface PictureDao {

    public List<Picture> selectAll(@Param("begin")int begin, @Param("size")int size);

    public Integer selectTotal();

    public int updata(@Param("picture")Picture picture);

    public int delete(@Param("id")String id);

    public int insert(@Param("picture")Picture picture);
}
