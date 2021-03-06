package com.liqiang.hrm.web.controller;

import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.FastDfsApiOpr;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@RestController
@RequestMapping
public class FastDfsController {
    Logger logger = LoggerFactory.getLogger(FastDfsController.class);//将controller的异常输出到日志就需要
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) {

        try {
            String fileName = file.getOriginalFilename(); // 1.png
            String extName = fileName.substring(fileName.lastIndexOf(".")+1);
            System.out.println(extName);
            return FastDfsApiOpr.upload(file.getBytes(),extName);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("上传图片出现错误："+e.getMessage());
        }
        return null;
    }

    @DeleteMapping("/delete")
    public AjaxResult delete(@RequestParam("path") String path) {
        ///group1/xxxx
        try {
            String pathTmp = path.substring(1); // goup1/xxxxx/yyyy
            String groupName =  pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
            String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);// xxxx/yyyy
            System.out.println("删除"+groupName);
            System.out.println("删除"+remotePath);
            FastDfsApiOpr.delete(groupName,remotePath);
            return AjaxResult.me();
        }catch (Exception e){
            e.printStackTrace();
            logger.error("删除图片出现错误："+e.getMessage());
            return AjaxResult.me().setSuccess(false).setMessage(e.getMessage());
        }
    }

    @GetMapping("/download")
    public void download(@RequestParam("path")String path, HttpServletResponse response) {
        String pathTmp = path.substring(1); // goup1/xxxxx/yyyy
        String groupName =  pathTmp.substring(0, pathTmp.indexOf("/")); //goup1
        String remotePath = pathTmp.substring(pathTmp.indexOf("/")+1);// xxxxx/yyyy
        System.out.println(groupName);
        System.out.println(remotePath);
        OutputStream os = null;
        InputStream is = null;
        try {
            byte[] datas = FastDfsApiOpr.download(groupName, remotePath);
            os = response.getOutputStream(); //直接给以流方式进行返回
            is = new ByteInputStream(datas,datas.length);
            IOUtils.copy(is,os);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("下载图片出现错误："+e.getMessage());
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

