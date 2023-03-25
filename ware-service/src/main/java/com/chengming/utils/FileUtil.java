package com.chengming.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * @Author: yichengming
 * @Date: 2021/09/13/10:08
 * @Description:
 */
public class FileUtil {


    public static String upload(MultipartFile originalFile) {

        Optional<MultipartFile> file = Optional.ofNullable(originalFile);
        if (!file.isPresent()) {
            return "文件为空";
        }
        String fileName = originalFile.getOriginalFilename();

        String suffix = fileName.substring(fileName.lastIndexOf("."));

        String fileDir = "D:/file/";

        String newFilePath = fileDir + fileName + suffix;

        File newFile = new File(newFilePath);

        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdir();
        }

        try {
            originalFile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "success";

    }

    public static String downLoad(String fileName) {

        return "success";
    }
}
