package com.yoke.backend.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@CrossOrigin
@RestController
@RequestMapping(value = "/time")
public class TimeController {
    @RequestMapping(value="/week",method = RequestMethod.GET)
    public long getWeek()
    {
        String start = "2019-09-09";
        long week=0;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            long from = df.parse(start).getTime();
            long to = new Date().getTime();
            week = (to-from)/(1000*3600*24*7)+1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return week;
    }

}
