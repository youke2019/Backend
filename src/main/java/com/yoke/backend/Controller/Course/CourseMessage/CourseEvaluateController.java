package com.yoke.backend.Controller.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
@RestController
@RequestMapping(value = "/courses/evaluates")
public class CourseEvaluateController {

    @Autowired
    CourseEvaluationService courseEvaluationService;

    /**
     * @api {get} /course/evaluates/find
     * @apiName findEvaluation
     * @apiDescription 获取课程评测
     * @apiParam {String} course_id
     * @apiGroup CourseMessage
     * @apiSampleRequest /course/evaluates/find?course_id=SE101
     * @param course_id
     * @apiSuccessExample Request-Example:
     * [
     *     {
     *         "course_id": "11004",
     *         "user_id": "01231",
     *         "credit_point": 90.0,
     *         "考核方式": "论文",
     *         "点名": "每节课都点名"
     *     },
     *     {
     *         "course_id": "11004",
     *         "user_id": "42257",
     *         "credit_point": 90.0,
     *         "考核方式": "论文",
     *         "点名": "每节课都点名",
     *         "给分": "给分很低"
     *     }
     * ]
     * @return
     */
    @GetMapping(value = "/find")
    public List<CourseEvaluation> findEvaluationByCourseId(String course_id,String user_id)
    {
        return courseEvaluationService.findEvaluationByCourseId(course_id,user_id);
    }

    /**
     * @api {post} /course/evaluates/add:
     * @apiName addEvaluation
     * @apiDescription 添加评测
     * @apiGroup CourseMessage
     * @apiSampleRequest /course/evaluates/add
     * @apiSuccessExample Request-Example:
     *     {
     * 	"course_id":"SE101",
     * 	"user_id":84514,
     * 	"点名":"偶尔点名"
     * }
     * @param json
     */
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    @ResponseBody
    public String addEvaluation(@RequestBody String json)
    {
        courseEvaluationService.addCourseEvaluation(json);
        return "success";
    }

    @GetMapping(value = "all")
    public List<CourseEvaluation> allEvaluation()
    {
        return courseEvaluationService.allEvaluation();
    }
}
