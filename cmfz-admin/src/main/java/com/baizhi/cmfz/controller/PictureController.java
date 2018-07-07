package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by 姚亚博 on 2018/7/5.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {

    @Autowired
    private PictureService ps;

    @RequestMapping("/showAll")
    @ResponseBody
    public Map<String,Object> showAll(@RequestParam("page")int nowPage, @RequestParam("rows")int pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",ps.queryTotal());
        map.put("rows",ps.queryAll(nowPage,pageSize));
        return map;
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String uplod(MultipartFile myFile, HttpServletRequest request,String pictureDescription,String pictureStatus) throws IOException {

        String realPath = request.getRealPath("").replace("cmfz","upload");

        //获取上传文件的文件名
        String fileName = myFile.getOriginalFilename();

        //将文件存入到指定目录下
        myFile.transferTo(new File(realPath+"/"+fileName));

        //-------------------------------------------------------
        //上传结束，数据入库

        //生成UUID作为Picture对象的ID
        String ID = UUID.randomUUID().toString().replace("-","");

        //获取上传时间
        Date date = new Date();

        Picture picture = new Picture();
        picture.setPictureDate(date);
        picture.setPictureId(ID);
        picture.setPicturePath(fileName);
        picture.setPictureDescription(pictureDescription);
        picture.setPictureStatus(pictureStatus);

        if( ps.add(picture)!=0){
            return "success";
        }else{
            return "false";
        }
    }

    /**
     * springmvc 400 错误 类型转换异常产生的
     * 1. springmvc默认支持处理的日期 2017/06/23
     * 2. 属性命名符合要求
     * 3. /modify.jsp
     * 4. @JsonField 响应的日期格式
     *    @DateTimeFormatter 请求的日期格式（yyyy-MM-dd HH:mm:ss）
     *
     */
    @RequestMapping("/modify")
    @ResponseBody
    public String modify(Picture picture){
        if(ps.modify(picture)!=0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("/remove")
    public int remove(String id){
        return ps.remove(id);
    }

}
