package com.trade.lq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 11:10
 */
@RestController
@Slf4j
public class DownloadControllor {

    @Value("${uploadDir}")
    private String uploadDir;
    //文件下载相关代码
    @RequestMapping(value = "/downloadFile",method = RequestMethod.GET)
    public String downloadImage(String imageName, HttpServletRequest request, HttpServletResponse response) {
        String fileName = "guanyinpusa.jpg";
        log.debug("the imageName is : "+imageName);
       // String fileUrl = uploadDir+imageName;
        String fileUrl = uploadDir+fileName;
        if (fileUrl != null) {
            //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
  /* String realPath = request.getServletContext().getRealPath(
   "F:/sbootDoc/resource/download/");*/
            String realPath = request.getServletContext().getRealPath("F:/sbootDoc/resource/download/");
            File file = new File(realPath, fileName);
           // File file = new File(fileUrl);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + imageName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
