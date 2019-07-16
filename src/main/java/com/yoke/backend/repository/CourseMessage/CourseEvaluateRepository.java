package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
public interface CourseEvaluateRepository extends JpaRepository<CourseEvaluation,Integer> {
    @Query(value="select * from course_evaluation where course_id=?1",nativeQuery = true)
    List<CourseEvaluation> findByCourseId(String course_id);

    @Query(value="select * from course_evaluation where course_id=?1 and ID=?2",nativeQuery = true)
    CourseEvaluation findByCourseIdAndUserId(String course_id,String user_id);
}
