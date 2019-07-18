package com.yoke.backend.repository.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestionPraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseQuestionPraiseRepository extends JpaRepository<CourseQuestionPraise,Integer> {
    @Transactional
    @Query(value = "delete from question_praise where question_id=?1 and ID=?2",nativeQuery = true)
    @Modifying
    void delete(Integer question_id,String user_id);
}
