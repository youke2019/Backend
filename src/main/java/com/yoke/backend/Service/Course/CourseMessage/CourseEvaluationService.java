package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;

import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
public interface CourseEvaluationService {

    List<CourseEvaluation> allEvaluation();
    List<CourseEvaluation> findEvaluationByCourseId(String course_id,String user_id);
    void addCourseEvaluation(String json);
    void praiseCourseEvaluation(Integer course_evaluate_id,String user_id);
    void unpraiseCourseEvaluation(Integer coures_evaluate_id,String user_id);
}
