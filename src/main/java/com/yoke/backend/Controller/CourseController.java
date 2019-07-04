package com.yoke.backend.Controller;


import com.yoke.backend.Entity.*;
import com.alibaba.fastjson.JSON;
import com.yoke.backend.Service.CourseService;
import com.yoke.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     *
     * @param url
     * @param cookies
     */
    @GetMapping("update")
    public void UpdateCourseInfoFromJWC(String url,String cookies) throws IOException {
        courseService.GetCourseFromJWC(url,cookies);
    }


    @RequestMapping(value = "/search", method= RequestMethod.POST)
    @ResponseBody
    public List<CourseInfo> SearchCourseInfo(@RequestBody SearchCourseInfoParams searchCourseInfoParams)
    {
        return courseService.SearchCourseInfo(searchCourseInfoParams);
    }

}

