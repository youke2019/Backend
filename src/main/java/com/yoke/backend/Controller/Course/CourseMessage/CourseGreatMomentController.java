package com.yoke.backend.Controller.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Service.Course.CourseMessage.CourseMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@RestController
@RequestMapping(value = "courses/moments")
public class CourseGreatMomentController {

    @Autowired
    CourseMomentService courseMomentService;


    @RequestMapping(value = "uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(@RequestParam(value = "img")MultipartFile img, HttpServletResponse response)
    {
        return "wait";
    }

    /**
     *
     * @param serialNumber1
     * @param serialNumber2
     * @return
     */
    @RequestMapping(value = "find")
    public List<CourseMoment> findByTimeOrder(Integer serialNumber1, Integer serialNumber2)
    {
        return courseMomentService.findByTimeOrder(serialNumber1, serialNumber2);
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "findAll")
    public List<CourseMoment> findAll()
    {
        return courseMomentService.findAll();
    }
}
