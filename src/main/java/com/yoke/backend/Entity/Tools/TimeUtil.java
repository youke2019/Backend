package com.yoke.backend.Entity.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
public class TimeUtil {
    public static String CurrentTime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
        Date date = new Date();
        return sdf.format(date);
    }
}
