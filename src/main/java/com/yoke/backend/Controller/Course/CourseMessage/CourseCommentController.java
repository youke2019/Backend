package com.yoke.backend.Controller.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import com.yoke.backend.Service.Course.CourseMessage.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
@CrossOrigin
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
     * @api {get} /courses/comments/find:
     * @apiName getcomment
     * @apiDescription 获得课程评论
     * @apiParam {String} course_id
     * @apiParam {String} user_id
     * @apiGroup CourseComment
     * @apiSampleRequest 47.103.30.166:8000/courses/comments/find
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
     * @param user_id
     * @return
     */
    @GetMapping(value = "/find")
    public List<CourseComment> findCommentByCourse(String course_id,String user_id)
    {
        return courseCommentService.findCommentByCourse(course_id,user_id);
    }

    /**
     *
     * @api {post} /courses/comments/add:
     * @apiName addComment
     * @apiDescription 添加评论
     * @apiGroup CourseComment
     * @apiSampleRequest 47.103.30.166:8000/courses/comments/add
     * @apiSuccessExample Post-Example:
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
     * @api {get} /courses/comments/delete:
     * @apiDescription 删除评论
     * @apiParam {Interger} user_id
     * @apiName deleteComment
     * @apiGroup CourseComment
     * @apiSampleRequest 47.103.30.166:8000/courses/comments/delete?comment_id=3
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
     * @api {get} /courses/comments/ban:
     * @apiDescription 封禁评论
     * @apiParam {Interger} comment_id
     * @apiName banComment
     * @apiGroup CourseComment
     * @apiSampleRequest 47.103.30.166:8000/courses/comments/ban?comment_id=2
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
     * @api {get} /courses/comments/unban:
     * @apiDescription 解禁评论
     * @apiParam {Interger} comment_id
     * @apiName unbanComment
     * @apiGroup CourseComment
     * @apiSampleRequest 47.103.30.166:8000/courses/comments/unban?comment_id=2
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
     * @api {get} /courses/comments/praise:
     * @apiDescription 点赞评论
     * @apiParam {String} user_id
     * @apiParam {Interger} course_comment_id
     * @apiName praiseComment
     * @apiGroup CourseComment
     * @apiSampleRequest example: /course/comments/praise?user_id=1&course_comment_id=2
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
     * @api {get} /courses/comments/unpraise:
     * @apiDescription 取消点赞评论
     * @apiParam {String} user_id
     * @apiParam {Interger} course_comment_id
     * @apiName unpraiseComment
     * @apiGroup CourseComment
     * @apiSampleRequest  example: /course/comments/unpraise?user_id=1&course_comment_id=2
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

    /**
     * @api {post} /courses/comments/reply:
     * @apiDescription 回复
     * @apiName replyComment
     * @apiGroup CourseComment
     * @apiSuccessExample Post-Example:
     *     {
     * 	"course_comment_id":1,
     * 	"user_id":84514,
     * 	"course_comment_reply_content":"说的很中肯"
     * }
     * @param courseCommentReply
     * @return
     */
    @RequestMapping(value = "/reply",method = RequestMethod.POST)
    @ResponseBody
    public String replyCourseComment(@RequestBody CourseCommentReply courseCommentReply)
    {
        return courseCommentService.replyCourseComment(courseCommentReply);
    }

    /**
     * @api {get} /courses/comments/findById
     * @apiName findCommentById
     * @apiGroup CourseComment
     * @apiDescription 通过ID查找课程评论（无回复）
     * @apiParam {Integer} comment_id
     * @param comment_id
     * @return
     */
    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public CourseComment findCourseCommentById(Integer comment_id)
    {
        return courseCommentService.findCommentById(comment_id);
    }
}
