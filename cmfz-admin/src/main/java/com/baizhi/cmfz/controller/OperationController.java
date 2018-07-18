package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 姚亚博 on 2018/7/10.
 */
@Controller
@RequestMapping("/operation")
public class OperationController {

    @Autowired
    private OperationService os;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(@RequestParam("page")int nowPage, @RequestParam("rows")int pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",os.queryTotal());
        map.put("rows",os.queryAll(nowPage,pageSize));
        return map;
    }

}
