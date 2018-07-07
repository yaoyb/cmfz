package com.baizhi.cmfz.controller;

import com.alibaba.fastjson.JSON;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public Map<String,Object> showAll(@RequestParam("page")int nowPage, @RequestParam("rows") int pageSize){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",ms.queryTotal());
        map.put("rows",ms.queryAll(nowPage,pageSize));
        return map;
    }

    @RequestMapping("showByName")
    @ResponseBody
    public Map<String,Object> showByName(@RequestParam("page")int nowPage,@RequestParam("rows") int pageSize,String name){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("total",ms.queryTotalByName(name));
        map.put("rows",ms.queryByName(nowPage,pageSize,name));
        return map;
    }

    @RequestMapping("change")
    @ResponseBody
    public String change(Master master){
        if(ms.modify(master)!=0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("add")
    @ResponseBody
    public String add(Master master,@RequestParam(value = "masterFile", required = false)MultipartFile masterFile, HttpServletRequest request) throws IOException {
        String realPath = request.getRealPath("").replace("cmfz","upload");

        //获取上传文件的文件名
        String fileName = masterFile.getOriginalFilename();
        //将文件存入到指定目录下

        masterFile.transferTo(new File(realPath+"/"+fileName));

        String ID = UUID.randomUUID().toString().replace("-","");
        master.setMasterId(ID);
        master.setMasterPhoto(fileName);
        if(ms.add(master)!=0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("/importMaster")
    @ResponseBody
    public String importExcel(MultipartFile subfile, HttpServletRequest request){
        try {
            ImportParams params = new ImportParams();
            params.setHeadRows(1);
            params.setNeedSave(true);

            String path=request.getSession().getServletContext().getRealPath("");

            File f = new File(path+"/excel/"+subfile.getOriginalFilename());

            if(!f.exists()){
                try {
                    File dir = new File(path+"/excel/");
                    dir.mkdirs();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            subfile.transferTo(f);
            List<Master> masters = ExcelImportUtil.importExcel(f,Master.class, params);
            for (Master master : masters) {
                String ID = UUID.randomUUID().toString().replace("-","");
                master.setMasterId(ID);
                master.setMasterPhoto(null);
                ms.add(master);
            }
            if(masters.isEmpty()){
                return "false";
            }
            return "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "false";
    }

}
