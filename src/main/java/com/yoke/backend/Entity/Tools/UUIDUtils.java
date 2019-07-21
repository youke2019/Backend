package com.yoke.backend.Entity.Tools;

import java.util.UUID;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:上传图片时可能会有用户的图片名称一致，使用UUID来对图片进行重新合成
 **/
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
