package com.yoke.backend.ServiceImpl.Course;


import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
public class CourseRecommendServiceImpl implements CourseRecommendService {
    @Autowired
    CourseEvaluationService courseEvaluationService;

    public List<CourseInfo> userBasedRecommend(String user_id)
    {
        List<CourseEvaluation> courseEvaluationList=courseEvaluationService.allEvaluation();
        return null;
    }
}
