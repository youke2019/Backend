package com.yoke.backend.Service.Course;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
public interface CourseEvaluationService {

    List<Map> allEvaluation();
    List<Map> findEvaluationByCourseId(String course_id);
    void addCourseEvaluation(String json);
}
