package com.yoke.backend.Entity.Tools;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
//图片上传工具类
public class FileUploadUtil {
    /**
     *
     * @param file 文件
     * @param path   文件存放路径
     * @param fileName 原文件名
     * @return
     */
    public static boolean upload(MultipartFile file, String path, String fileName){

        // 生成新的文件名
        String realPath = path + "/" +fileName;

        //使用原文件名
        // String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            System.out.println(dest.getName());
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println(file.getName());
            System.out.println("illegalstateexception");
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ioexception");
            return false;
        }

    }

}
