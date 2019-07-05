package com.yoke.backend.Controller;


import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import com.yoke.backend.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * @api {get} /courses/update
     * @apiDescription 拉取并更新教务处数据
     * @apiName updateCourseInfoFromJWC
     * @apiGroup courses
     * @apiVersion 1.0.0
     *
     * @apiParam {String} url
     * @apiParam {String} Cookies
     *
     * @param url
     * @param cookies
     */
    @GetMapping("update")
    public void UpdateCourseInfoFromJWC(String url,String cookies) throws IOException {
        courseService.GetCourseFromJWC(url,cookies);

    }

    /**
     * @api {get} /courses/search
     * @apiDescription 根据条件搜索课程
     * @apiName SearchCourseInfo
     * @apiGroup courses
     * @apiVersion 1.0.0
     * @apiParams 很多, 懒得写了
     */
    @RequestMapping(value = "/search", method= RequestMethod.POST)
    @ResponseBody
    public List<CourseInfo> SearchCourseInfo(@RequestBody SearchCourseInfoParams searchCourseInfoParams)
    {
        return courseService.SearchCourseInfo(searchCourseInfoParams);
    }

}

