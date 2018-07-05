package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
@Controller
@RequestMapping("picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("showAll")
    @ResponseBody
    public List<Picture> showAll(@RequestParam("page")int nowPage, @RequestParam("rows")int pageSize){
        System.out.println(pageSize    );
        return ps.queryAll(nowPage,pageSize) ;
    }

    @RequestMapping("remove")
    public int remove(String id){
        return ps.remove(id);
    }

    @RequestMapping("modify")
    public int modify(Picture picture){
        return ps.modify(picture);
    }

    @RequestMapping("add")
    public int add(Picture picture){
        return ps.add(picture);
    }
}
