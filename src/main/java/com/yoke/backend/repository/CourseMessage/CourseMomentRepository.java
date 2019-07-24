package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentRepository extends JpaRepository<CourseMoment,Integer> {
    @Query(value = "select * from video order by video.post_time desc limit ?1,?2 ",nativeQuery = true)
    List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2);

    @Query(value = "select * from video order by video.post_time desc",nativeQuery = true)
    List<CourseMoment> findCourseMoment();
}
