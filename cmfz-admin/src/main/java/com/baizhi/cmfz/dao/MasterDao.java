package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/6.
 */
public interface MasterDao {
    public List<Master> selectAll(@Param("begin") int begin, @Param("size") int size);

    public List<Master> selectByName(@Param("begin")int begin,@Param("size")int size,@Param("name")String name);

    public int insert(@Param("master")Master master);

    public int updata(@Param("master")Master master);
}
