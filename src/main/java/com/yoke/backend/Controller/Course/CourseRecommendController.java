package com.yoke.backend.Controller.Course;

import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Service.Course.CourseRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/31
 * @description:
 **/
@CrossOrigin
@RestController
@RequestMapping("courses/recommend")
public class CourseRecommendController {

    @Autowired
    CourseRecommendService courseRecommendService;

    /**
     *
     * @api {get} courses/recommend/find
     * @apiDescription 获得用户的推荐课程
     * @apiName  CoursesRecommend
     * @apiGroup  CourseRecommend
     * @apiParam {String} user_id
     * @apiParam {Integer} size
     * @apiHeaderExample {json} Response-Example:
     * [
     *     {
     *         "course_id": "LA116",
     *         "course_name": "刑法分论",
     *         "course_hours": 48,
     *         "course_credits": 3.0,
     *         "general": false,
     *         "general_type": "",
     *         "course_deptname": "凯原法学院"
     *     }
     * ]
     * @param user_id
     * @param size
     * @return
     */
    @RequestMapping(value = "find",method = RequestMethod.GET)
    public List<CourseInfo> recommendCourseInfo(String user_id, Integer size) {
        if(user_id!=null&&size!=null)
            return courseRecommendService.courseRecommend(user_id,size);
        else {
            System.out.println("参数错误");
            return null;
        }
    }


    /**
     * @api {get} /courses/recommend/data/generate
     * @apiDescription 获得机器学习推荐课程所需要的DataModel，适用于开发时期由于数据量不足，生成模拟数据
     * @apiGroup CourseRecommend
     * @apiName DataGeneration
     * 生成测试数据,限开发者使用
     * @return
     */
    @RequestMapping(value = "data/generate",method = RequestMethod.GET)
    public String recommendTest()
    {
        return courseRecommendService.generateData();
    }

    /**
     * @api {get} courses/recommend/data/load
     * @apiDescription 将评测中的数据导入DataModel
     * @apiName loadEvaluationData
     * @apiGroup CourseRecommend
     * @return
     */
    @RequestMapping(value = "data/load",method = RequestMethod.GET)
    public Integer loadEvaluationData()
    {
        return courseRecommendService.loadData();
    }

}
