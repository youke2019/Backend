package com.yoke.backend.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping(value = "/time")
public class TimeController {
    @RequestMapping(value="/week",method = RequestMethod.GET)
    public int getWeek()
    {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Long now = new Date().getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(now);
        calendar.set(calendar.MONTH,2);
        calendar.set(Calendar.DAY_OF_MONTH, 25);
        calendar.set(Calendar.HOUR, 14);
        calendar.set(Calendar.MINUTE, 23);
        calendar.set(Calendar.SECOND, 6);
        calendar.set(Calendar.MILLISECOND, 138);
        long start = calendar.getTimeInMillis();
        Date time = new Date();
        long end = time.getTime();
        int week = (int)((end - start)/(1000*60*60*24*7))+1;
        return week;
    }
}
