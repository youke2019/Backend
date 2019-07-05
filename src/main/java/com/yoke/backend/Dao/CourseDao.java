package com.yoke.backend.Dao;

import com.yoke.backend.Entity.Course.CourseInfo;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/

public interface CourseDao {
    List<CourseInfo> findAll();
    void save(CourseInfo courseInfo);
    List<CourseInfo> findCourseInfoByCourseId(String cours_id);
    /*List<CourseInfo> findCourseInfoByCourseName(String course_name);
    List<CourseInfo> findCourseInfoByTeacherName(String teacher_name);*/
}
