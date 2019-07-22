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
     * @apiGroup CourseEvaluate
     * @apiSampleRequest /course/evaluates/find?course_id=SE101
     * @param course_id
     * @apiSuccessExample Request-Example:
     * [{
     *         "evaluate_id": 4,
     *         "evaluate_time": "2019-07-22 14:03:35",
     *         "user_id": "01231",
     *         "course_id": "SE101",
     *         "evaluate_content": {
     *             "course_id": "SE101",
     *             "evaluate_id": 4,
     *             "给分情况": "给分高",
     *             "user_id": "01231",
     *             "evaluate_point": 5
     *         },
     *         "evaluate_praise_point": 0,
     *         "current_user_praise": false,
     *         "courseEvaluationPraiseList": []
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
     * @apiGroup CourseEvaluate
     * @apiSampleRequest /course/evaluates/add
     * @apiSuccessExample Request-Example:
     *     {
     * 	"course_id":"SE101",  //必填
     * 	"user_id":"01231",   //必填
     * 	"evaluate_point":5,
     * 	"给分情况":"给分高"
     * }
     * @param json
     */
    @RequestMapping(value = "/add", method= RequestMethod.POST)
    @ResponseBody
    public String addEvaluation(@RequestBody String json)
    {
        List<Map> responce = courseEvaluationService.allEvaluation();
        Integer result = responce.size();
        courseEvaluationService.addCourseEvaluation(json);
        responce = courseEvaluationService.allEvaluation();
        if(( responce.size() - result) == 1)
            return "success";
        else return "failure";

    }

    @GetMapping(value = "all")
    public List<CourseEvaluation> allEvaluation()
    {
        return courseEvaluationService.allEvaluation();
    }

    /**
     * @api {get} /courses/evaluates/praise
     * @apiGroup CourseEvaluate
     * @apiName praiseEvaluation
     * @apiParam {Interger} course_evaluate_id
     * @apiParam {String}  user_id
     * @apiDescription 点赞
     * @param course_evaluate_id
     * @param user_id
     * @return
     */
    @GetMapping(value = "/praise")
    public String praiseEvaluation(Integer course_evaluate_id,String user_id)
    {
        if(course_evaluate_id==null||user_id==null)
            return "参数错误了";
        courseEvaluationService.praiseCourseEvaluation(course_evaluate_id, user_id);
        return "success";
    }

    /**
     * @api {get} /courses/evaluates/unpraise
     * @apiGroup CourseEvaluate
     * @apiName unpraiseEvaluation
     * @apiDescription 取消点赞
     * @apiParam {Interger} course_evaluate_id
     * @apiParam {String}  user_id
     * @param course_evaluate_id
     * @param user_id
     * @return
     */
    @GetMapping(value = "/unpraise")
    public String unpraiseEvaluation(Integer course_evaluate_id,String user_id)
    {
        if(course_evaluate_id==null||user_id==null)
            return "参数错误";
        courseEvaluationService.unpraiseCourseEvaluation(course_evaluate_id, user_id);
        return "success";
    }

}
