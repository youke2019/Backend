package com.yoke.backend.Controller;


import com.yoke.backend.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;

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

}

