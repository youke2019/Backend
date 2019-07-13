package com.yoke.backend.Controller;

import com.yoke.backend.Entity.Comment.CourseComment;
import com.yoke.backend.Service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
@RestController
@RequestMapping(value = "/courses/comments")
public class CourseCommentController {
    @Autowired
    CourseCommentService courseCommentService;

    @GetMapping(value = "/all")
    public List<CourseComment> allComment()
    {
        return courseCommentService.allComment();
    }

    /**
     *
     * @param course_id
     * @return
     */
    @GetMapping(value = "/sortbycourseid")
    public List<CourseComment> findCommentByCourse(String course_id)
    {
        return courseCommentService.findCommentByCourse(course_id);
    }

    @RequestMapping(value = "/add", method= RequestMethod.POST)
    @ResponseBody
    public String userCommentCourse(@RequestBody CourseComment courseComment)
    {
        courseCommentService.userCommentCourse(courseComment);
        return "success";
    }

    /**
     *
     * @param comment_id
     * @return
     */
    @GetMapping(value = "withdraw")
    public String withdrawCommentOfCourse(Integer comment_id)
    {
        courseCommentService.withdrawCommentOfCourse(comment_id);
        return "success";
    }

    /**
     *
     * @param comment_id
     * @return
     */
    @RequestMapping(value="ban")
    public String banCommentOfCourse(Integer comment_id)
    {
        courseCommentService.banCommentOfCourse(comment_id);
        return "success";
    }

    /**
     *
     * @param comment_id
     * @return
     */
    @RequestMapping(value = "unban")
    public String unbanCommentOfCourse(Integer comment_id)
    {
        courseCommentService.unbanCommentOfCourse(comment_id);
        return "success";
    }
}
