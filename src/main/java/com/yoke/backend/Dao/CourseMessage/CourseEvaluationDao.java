package com.yoke.backend.Dao.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;

import javax.persistence.Id;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
public interface CourseEvaluationDao {
    void save(CourseEvaluation courseEvaluation);
    List<CourseEvaluation> findByCourseId(String course_id);
    void delete(Integer course_evaluate_id);
    CourseEvaluation findByCourseIdAndUserId(String course_id,String user_id);
}
