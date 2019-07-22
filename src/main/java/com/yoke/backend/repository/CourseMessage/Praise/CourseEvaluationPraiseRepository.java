package com.yoke.backend.repository.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
public interface CourseEvaluationPraiseRepository extends JpaRepository<CourseEvaluationPraise,Integer> {
    @Transactional
    @Query(value = "delete from coures_evaluate_praise where course_evaluate_id=?1 and ID=?2",nativeQuery = true)
    @Modifying
    void delete(Integer answer_id,String user_id);
}
