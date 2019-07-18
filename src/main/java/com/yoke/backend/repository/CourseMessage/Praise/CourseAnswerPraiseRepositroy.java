package com.yoke.backend.repository.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseAnswerPraiseRepositroy extends JpaRepository<CourseAnswerPraise,Integer> {
    @Transactional
    @Query(value = "delete from answer_praise where answer_id=?1 and ID=?2",nativeQuery = true)
    @Modifying
    void delete(Integer answer_id,String user_id);
}
