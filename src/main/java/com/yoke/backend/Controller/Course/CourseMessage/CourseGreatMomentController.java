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
     * @api {get} /courses/moments/findAll
     * @apiName findCourseMoment
     * @apiDescription 查找所有精彩瞬间
     * @apiGroup CourseMessage
     * @apiParam {String} user_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "findAll")
    public List<CourseMoment> findAll(String user_id)
    {
        return courseMomentService.findAll(user_id);
    }

    /**
     * @api {get} /courses/moments/praise
     * @apiName praiseCourseMoment
     * @apiDescription 对课程精彩瞬间进行点赞
     * @apiGroup courses/message
     * @apiParam {Integer} video_id
     * @apiParam {Integer} user_id
     * @param video_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "praise")
    public String praiseCourseMoment(Integer video_id,String user_id)
    {
        courseMomentService.praiseCourseMoment(video_id, user_id);
        return "success";
    }

    /**
     * @api {get} /courses/moments/unpraise
     * @apiName unpraiseCourseMoment
     * @apiDescription 对课程精彩瞬间取消点赞
     * @apiGroup courses/message
     * @apiParam {Integer} video_id
     * @apiParam {Integer} user_id
     * @param video_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "unpraise")
    public String unpraiseCourseMoment(Integer video_id,String user_id)
    {
        courseMomentService.unpraiseCourseMoment(video_id, user_id);
        return "success";
    }
}
