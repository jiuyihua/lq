package com.trade.lq.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 5:19
 */
@Slf4j
public class UploadFileUtil {

    public static Boolean uploadfile(MultipartFile mfile) {

        String fileName = mfile.getOriginalFilename();
        log.info("fileName=" + fileName);
        File file = new File("F:/sbootDoc/"+fileName);
        try {
            mfile.transferTo(file);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}

