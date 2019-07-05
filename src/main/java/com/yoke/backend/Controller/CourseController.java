package com.yoke.backend.Controller;


import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import com.yoke.backend.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    /**
     * @api {get} /courses/update
     * @apiDescription 拉取并更新教务处数据
     * @apiName updateCourseInfoFromJWC
     * @apiGroup courses
     * @apiVersion 1.0.0
     *
     * @apiParam {String} url
     * @apiParam {String} Cookies
     *
     * @param url
     * @param cookies
     */
    @GetMapping("update")
    public void UpdateCourseInfoFromJWC(String url,String cookies) throws IOException {
        courseService.GetCourseFromJWC(url,cookies);

    }

    /**
     * @api {post} /courses/search
     * @apiDescription 根据条件搜索课程,通过post发送请求，请求参数通过json传输，json数据示例如下，所有的数据项均可为空，
     * 即可以只有course_id的信息，所有的参数项中，course_id,course_name,teacher_name,building只能有一个，其他参数可以传递一个或者多个。
     * @apiName SearchCourseInfo
     * @apiGroup courses
     * @apiVersion 1.0.0
     * @apiHeaderExample {json} Request-Example:
     *                  { "course_id": "SE101",
     *                    "course_name":"计算机系统基础（1）",
     *                    "teacher_name":"藏斌宇",
     *                    "course_types":["0"],        // 0:非通识，1：通识
     *                    "general_types":["人文学科"],   //"社会学科","人文学科","自然学科","工程科学与技术","",
     *                    "weekdays":[1,2],
     *                    "begin_sec":[1,2,3],
     *                    "end_sec":[3,4,5],
     *                    "building":"东上院",
     *                    "course_credits":[2,3,4]
     *                     }
     *@apiHeaderExample {json} Response-Example:
     * [
     *     {
     *         "course_id": "SE101",
     *         "course_name": "计算机系统基础（1）",
     *         "course_hours": 80,
     *         "course_credits": 5,
     *         "general": false,
     *         "general_type": "",
     *         "classes": [
     *             {
     *                 "classname": "2018-2019-1-SE101-392689",
     *                 "course_id": "SE101",
     *                 "teacher_id": "11145",
     *                 "teacher_name": "臧斌宇",
     *                 "teachers": "11145/臧斌宇/教授[电子信息与电气工程学院];10886/陈榕/副教授[电子信息与电气工程学院]",
     *                 "course_participants": 48,
     *                 "classSegments": [
     *                     {
     *                         "class_sec_id": 9250,
     *                         "classname": "2018-2019-1-SE101-392689",
     *                         "classroom": "东上院102",
     *                         "begin_week": 1,
     *                         "end_week": 16,
     *                         "begin_sec": 7,
     *                         "end_sec": 8,
     *                         "week": 2,
     *                         "oddOrEven": "b"
     *                     },
     *                     {
     *                         "class_sec_id": 9251,
     *                         "classname": "2018-2019-1-SE101-392689",
     *                         "classroom": "东上院102",
     *                         "begin_week": 1,
     *                         "end_week": 16,
     *                         "begin_sec": 7,
     *                         "end_sec": 8,
     *                         "week": 2,
     *                         "oddOrEven": "b"
     *                     },
     *                     {
     *                         "class_sec_id": 9252,
     *                         "classname": "2018-2019-1-SE101-392689",
     *                         "classroom": "东上院102",
     *                         "begin_week": 1,
     *                         "end_week": 16,
     *                         "begin_sec": 3,
     *                         "end_sec": 4,
     *                         "week": 5,
     *                         "oddOrEven": "b"
     *                     },
     *                     {
     *                         "class_sec_id": 9253,
     *                         "classname": "2018-2019-1-SE101-392689",
     *                         "classroom": "东上院102",
     *                         "begin_week": 1,
     *                         "end_week": 16,
     *                         "begin_sec": 3,
     *                         "end_sec": 4,
     *                         "week": 5,
     *                         "oddOrEven": "b"
     *                     }
     *                 ]
     *             }
     *         ]
     *     }
     * ]
     *
     *
     */
    @RequestMapping(value = "/search", method= RequestMethod.POST)
    @ResponseBody
    public List<CourseInfo> SearchCourseInfo(@RequestBody SearchCourseInfoParams searchCourseInfoParams)
    {
        return courseService.SearchCourseInfo(searchCourseInfoParams);
    }

}

