package com.yoke.backend.Dao.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/

public interface CourseEvaluateDao {
    CourseEvaluation save(CourseEvaluation courseEvaluation);
    List<CourseEvaluation> findByCourse(String course_id);
    CourseEvaluation findById(Integer course_evaluate_id);
}
