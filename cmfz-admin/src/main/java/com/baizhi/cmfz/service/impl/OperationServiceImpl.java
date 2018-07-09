package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.OperationDao;
import com.baizhi.cmfz.entity.Operation;
import com.baizhi.cmfz.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/9.
 */
@Service
@Transactional
public class OperationServiceImpl implements OperationService {
    @Autowired
    OperationDao od;

    @Override
    public List<Operation> queryAll(int nowPage, int pageSize) {
        return null;
    }

}
