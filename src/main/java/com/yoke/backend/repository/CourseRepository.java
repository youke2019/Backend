package com.yoke.backend.repository;
import com.yoke.backend.Entity.CourseInfo;
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

    @Query(value = "select * from course where course_id = ?1", nativeQuery = true)
    List<CourseInfo> findCourseByCourse_id(String course_id);

    //List<CourseInfo> findCourseInfoByCourseId(String course_id);

    /*@Query("select u from course where u.course_name=:course_name")
    List<CourseInfo> findCourseInfoByCourseName(@Param("course_name") String course_name);

    @Query("select u from course where u.teacher_name=:teacher_name")
    List<CourseInfo> findCourseInfoByTeacherId(@Param("teacher_name") String teacher_name);*/
}
