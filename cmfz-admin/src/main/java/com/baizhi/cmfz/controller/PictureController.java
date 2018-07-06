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
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping("upload")
    public void uplod(MultipartFile myFile, HttpServletRequest request,String picture_description,String picture_status) throws IOException {


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

        Picture picture  = new Picture(ID,fileName,date,picture_description,picture_status);

        ps.add(picture);
    }

    @RequestMapping("remove")
    public int remove(String id){
        return ps.remove(id);
    }

    @RequestMapping("modify")
    public void modify(String picture_id, String picture_path, Date picture_date, String picture_description, String picture_status){
        Picture picture = new Picture(picture_id,picture_path,picture_date,picture_description,picture_status);
        ps.modify(picture);
//        return 0;
    }

}
