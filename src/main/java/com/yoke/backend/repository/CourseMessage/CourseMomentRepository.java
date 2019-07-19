package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentRepository extends JpaRepository<CourseMoment,Integer> {
    @Query(value = "select * from (select * from course order by course.course_id limit ?2) as m order by m.course_id desc limit ?2-?1; ",nativeQuery = true)
    List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2);
}
