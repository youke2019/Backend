package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseQuestionRepository extends JpaRepository<CourseQuestion,Integer> {
    @Query(value="select * from question where course_id=?1 and question_isbanned=0",nativeQuery = true)
    List<CourseQuestion> findQuestionByCourse(String course_id);
}
