package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Rich;
import com.baizhi.cmfz.service.ArticleService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 * Created by 姚亚博 on 2018/7/8.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService as;

    @RequestMapping("add")
    @ResponseBody
    public String add(Article article,String masterId){
        Date date = new Date();
        String ID = UUID.randomUUID().toString().replace("-","");
        article.setArticleId(ID);
        article.setArticleDate(date);
        Master m = new Master();
        m.setMasterId(masterId);
        article.setMaster(m);
        if(as.add(article)!=0){
            return "success";
        }
        return "false";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public Rich uploadFiles(@RequestParam("files") MultipartFile[] files, HttpServletRequest request){
        //用于返回文件内容在编辑框中
        Rich rich = new Rich();
        ArrayList<String> data =new ArrayList<String>();
        try {
            String realPath = request.getRealPath("");
            String uploadPath=realPath.substring(0,realPath.lastIndexOf("\\"))+"\\upload\\article";
            if(files!=null && files.length!=0){
                for (MultipartFile file : files) {
                    String fileName = UUID.randomUUID().toString()+"."+ FilenameUtils.getExtension(file.getOriginalFilename());
                    file.transferTo(new File(uploadPath+"\\"+fileName));
                    data.add(request.getContextPath()+"/upload/article/"+fileName);
                }
                rich.setErrno(0);
                rich.setData(data);
            }
        } catch (IOException e) {
            rich.setErrno(1);
            e.printStackTrace();
        }
        return rich;

    }
}
