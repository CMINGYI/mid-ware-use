package com.chengming.business;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Name: ExcelBiz
 * @Author: kitchening
 * @Date: 2023-03-25 18:34
 * @Description: ExcelBiz
 * @Version: V1.0
 */
public interface ExcelBiz {

    /**
     * 统计加班时长
     *
     * @param filePath
     * @return
     */
    String countOvertimeHours(String filePath);

    /**
     * 统计加班时长
     *
     * @return
     */
    String countOvertimeHoursByTable(String filePath);


    /**
     * 上传文件
     *
     * @param multipartFile
     * @return
     */
    String uploadFile(MultipartFile multipartFile);
}
