package com.trade.lq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 5:10
 */

@Slf4j
@RestController
public class UploadControllor {

    @Value("${uploadDir}")
    private String uploadDir;

    @GetMapping("/uploadFile")
    @ResponseBody
    public String uploadFiles(@RequestParam("file") MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        log.info("fileName=" + fileName);
        //绝对路径
        File f = new File(uploadDir+fileName);
        file.transferTo(f);
        return "成功！";
    }

    @GetMapping("/uploadFiles")
    @ResponseBody
    public String uploadFiles(@RequestParam("file") MultipartFile[] files)  {
        String fileName = null;
        String msg = "";

        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File(uploadDir + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    msg += "You have successfully uploaded " + fileName;
                } catch (Exception e) {
                    return "You failed to upload " + fileName + ": " + e.getMessage();
                }
            }
        }else {
            return "file is null";
        }
        return msg;

    }

    /*用于解决servlet容器（jetty tomcat）不同问题*/
    @GetMapping("/uploadFiles2")
    @ResponseBody
    public String uploadFiles2(@RequestParam("file") MultipartFile[] files)  {
        String fileName = null;
        String msg = "";
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                try {
                    MultipartFile multipartFile = files[i];
                    fileName = multipartFile.getOriginalFilename();
                    Path path = FileSystems.getDefault().getPath(uploadDir,fileName);
                    multipartFile.transferTo(path);
                    msg += "You have successfully uploaded " + fileName;
                } catch (Exception e) {
                    return "You failed to upload " + fileName + ": " + e.getMessage();
                }
            }
        }else {
            return "file is null";
        }
        return msg;

    }

}
