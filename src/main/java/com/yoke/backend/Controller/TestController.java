package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Dao.CourseDao;
import com.yoke.backend.Entity.CourseInfo;
import com.yoke.backend.repository.ClassRepository;
import com.yoke.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = "/testOR")
    public List<CourseInfo>  allCourse()
    {
        return courseDao.findAll();
    }

    @GetMapping(value = "/testSV")
    public List<CourseInfo> saveCourse() {

        return courseDao.findAll();
    }
}
