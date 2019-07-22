package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluation,Integer> {
    @Query(value = "select * from course_evaluate where course_id=?1",nativeQuery = true)
    List<CourseEvaluation> findByCourse(String course_id);
}
