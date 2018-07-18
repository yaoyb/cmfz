package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Operation;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
public interface OperationService {
    public List<Operation> queryAll(int nowPage,int pageSize);

    public Integer queryTotal();

}
