package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Created by 姚亚博 on 2018/7/6.
 */
@Controller
@RequestMapping("/master")
public class MasterController {

    @Autowired
    MasterService ms;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Master> showAll(@RequestParam("page")int nowPage,@RequestParam("rows") int pageSize){
        return ms.queryAll(nowPage,pageSize);
    }

    @RequestMapping("showByName")
    @ResponseBody
    public List<Master> showByName(@RequestParam("page")int nowPage,@RequestParam("rows") int pageSize,String name){
        return ms.queryByName(nowPage,pageSize,name);
    }

    @RequestMapping("change")
    public void change(Master master){
        ms.modify(master);
    }

    @RequestMapping("add")
    public void add(Master master){
        String ID = UUID.randomUUID().toString().replace("-","");
        master.setMasterId(ID);
        ms.add(master);
    }


}
