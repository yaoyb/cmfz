package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    /**
     *定义关于文件上传的Controller方法
     * 用于将文件上传至目标文件夹下
     * 以及调用Service方法将数据入库
     */
    @RequestMapping("add")
    @ResponseBody
    public String add(Master master,@RequestParam(value = "masterFile", required = false)MultipartFile masterFile, HttpServletRequest request) throws IOException, MyException {
        ClientGlobal.init("fdfs_client.conf");

        TrackerClient trackerClient = new TrackerClient();

        TrackerServer trackerServer = trackerClient.getConnection();

        StorageClient storageClient = new StorageClient(trackerServer, null);

        //获取后缀名
        String fileName = masterFile.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);

        String[] fileId = storageClient.upload_file(masterFile.getBytes(),suffix,null);

        //拼接该文件的名称
        String path ="";
        for(String s:fileId){
            path+=s;
        }

        //----------------------------------------------

        System.out.println("Path:"+path);
        String ID = UUID.randomUUID().toString().replace("-","");
        master.setMasterId(ID);
        master.setMasterPhoto(path);
        if(ms.add(master)!=0){
            return "success";
        }else{
            return "false";
        }
    }
    /*
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
    */

    @RequestMapping("/importMaster")
    @ResponseBody
    public String importExcel(MultipartFile subfile, HttpServletRequest request){
        try {
            ImportParams importParams = new ImportParams();
            //三个参数：输入流；实体类对象：参数对象
            List<Master> masters = ExcelImportUtil.importExcel(subfile.getInputStream(),Master.class,importParams);
            for (Master master : masters){
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

    @RequestMapping("/exportMaster")
    @ResponseBody
    public void exportMaster(HttpServletResponse response) throws IOException {
        List<Master> masters = ms.queryExcel();
        ExportParams exportParams = new ExportParams("诸位上师","上师表");
        //Excel文件
        //三个参数：参数对象；实体类对象；导出的数据集合
        //workbook.write(输出流)即可
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams,Master.class,masters);

        //设置输出流
        ServletOutputStream stream = response.getOutputStream();
        //文件下载 设置响应头
        //响应头 默认使用的编码格式为iso-8859-1
        String fileName = new String("上师信息.xls".getBytes(),"iso-8859-1");

        response.setContentType("applocation/vnd.ms-excel");
        response.setHeader("content-disposition","attachment;fileName="+fileName);

        workbook.write(stream);
        stream.close();
    }

    @RequestMapping("/showAllMaster")
    @ResponseBody
    public List<Master> showAllMaster(){
        return ms.queryExcel();
    }

}
