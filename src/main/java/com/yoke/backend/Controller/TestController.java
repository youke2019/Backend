package com.yoke.backend.Controller;

import com.yoke.backend.Dao.CourseDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Service.CourseService;
import com.yoke.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
@RestController
public class TestController {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseRepository repository;

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/testOR")
    public List<CourseInfo>  allCourse() throws IOException {
        return courseDao.findAll().subList(0,1) ;
    }

    @GetMapping(value = "/testSV")
    public List<CourseInfo> saveCourse() {
        return courseDao.findAll();
    }
}
