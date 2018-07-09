package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Operation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
public interface OperationDao {
    public List<Operation> selectAll(@Param("begin")int begin, @Param("size")int size);

    public int insert(Operation operation);
}
