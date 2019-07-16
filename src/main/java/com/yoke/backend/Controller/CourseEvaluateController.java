package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Service.Course.CourseEvaluationService;
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
     * @apiGroup CourseMessage
     * @apiPram  通过课程ID查找评测
     * @apiPram  example: /course/evaluates/find?course_id=SE101
     * @param course_id
     * @return
     */
    @GetMapping(value = "/find")
    public List<Map> findEvaluationByCourseId(String course_id)
    {
        return courseEvaluationService.findEvaluationByCourseId(course_id);
    }

    /**
     * @api {post} /course/evaluates/add:
     * @apiName addEvaluation
     * @apiGroup CourseMessage
     * @apiPram  添加课程评测
     * @apiPram  example: /course/evaluates/add
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
    public void addEvaluation(@RequestBody String json)
    {
        courseEvaluationService.addCourseEvaluation(json);
    }

    @GetMapping(value = "all")
    public List<Map> allEvaluation()
    {
        return courseEvaluationService.allEvaluation();
    }
}