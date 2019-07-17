package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Service.Course.CourseCommentService;
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
     * @api {get} /course/comments/find:
     * @apiName getcomment
     * @apiGroup CourseMessage
     * @apiPram  获取评论
     * @apiSuccessExample Response-Example:
     *[
     *     {
     *         "course_comment_id": 1,
     *         "course_id": "41899",
     *         "course_comment_time": "6P467",
     *         "course_comment_content": "H7I2K",
     *         "user_id": 79832,
     *         "isbanned": true,
     *         "course_comment_praise_point": -1432851621
     *     }
     *     ]
     *
     * @param course_id
     * @return
     */
    @GetMapping(value = "/find")
    public List<CourseComment> findCommentByCourse(String course_id)
    {
        return courseCommentService.findCommentByCourse(course_id);
    }

    /**
     *
     * @api {post} /course/comments/add:
     * @apiName addComment
     * @apiGroup CourseMessage
     * @apiPram  添加评论
     * @apiSuccessExample Request-Example:
     *     {
     * 	"course_id":"SE101",
     * 	"user_id":84514,
     * 	"course_comment_content":"ics是交大的镇校神课"
     * }
     *
     * @param courseComment
     * @return
     */
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    @ResponseBody
    public String userCommentCourse(@RequestBody CourseComment courseComment)
    {
        courseCommentService.userCommentCourse(courseComment);
        return "success";
    }

    /**
     * @api {get} /course/comments/delete:
     * @apiName withdrawComment
     * @apiGroup CourseMessage
     * @apiPram  撤回评论
     * @param comment_id
     * @return
     */
    @GetMapping(value = "delete")
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

    /**
     * @api {get} /course/comments/praise:
     * @apiName praiseComment
     * @apiGroup CourseMessage
     * @apiPram  点赞
     * @apiPram  example: /course/comments/praise?user_id=1&course_comment_id=2
     * @param user_id
     * @param course_comment_id
     * @return
     */
    @RequestMapping(value = "/praise")
    public String praiseCourseComment(String user_id,Integer course_comment_id)
    {
        courseCommentService.praiseCourseComment(user_id,course_comment_id);
        return "success";
    }

    /**
     * @api {get} /course/comments/unpraise:
     * @apiName unpraiseComment
     * @apiGroup CourseMessage
     * @apiPram  取消点赞
     * @apiPram  example: /course/comments/unpraise?user_id=1&course_comment_id=2
     * @param user_id
     * @param course_comment_id
     * @return
     */
    @RequestMapping(value = "/unpraise")
    public String unpraiseCourseComment(String user_id,Integer course_comment_id)
    {
        courseCommentService.unpraiseCourseComment(user_id,course_comment_id);
        return "successs";
    }

}
