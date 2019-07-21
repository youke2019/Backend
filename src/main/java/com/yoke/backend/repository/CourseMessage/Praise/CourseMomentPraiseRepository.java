package com.yoke.backend.repository.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentPraiseRepository extends JpaRepository<CourseMomentPraise,Integer> {

    @Transactional
    @Query(value = "delete from video_praise where video_id=?1 and ID=?2",nativeQuery = true)
    @Modifying
    void delete(Integer video_id,String user_id);
}
