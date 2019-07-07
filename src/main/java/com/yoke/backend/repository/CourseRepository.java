package com.yoke.backend.repository;
import com.yoke.backend.Entity.Course.CourseInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
public interface CourseRepository extends JpaRepository<CourseInfo,Integer> {


    @Query(value="select course.* from course,course_class,class_segments where course.course_id=course_class.course_id and course_class.classname=class_segments.classname and course.course_id like %?1% and course.course_name like %?2% and course_class.teacher_name like %?3% and general in ?4 and general_type in ?5 and class_segments.week in ?6 and class_segments.begin_sec in ?7 and class_segments.end_sec in ?8 and class_segments.classroom like ?9% and course_credits in ?10 group by course.course_id" ,nativeQuery = true)
    List<CourseInfo> findCourse(String course_id,String course_name,String teacher_name,List<Integer> course_types,List<String> general_types,
                                List<Integer> weekdays,List<Integer> begin_secs,List<Integer> end_secs,String building,List<Double> course_credits);

}