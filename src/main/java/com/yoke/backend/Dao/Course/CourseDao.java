package com.yoke.backend.Dao.Course;

import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/

public interface CourseDao {
    List<CourseInfo> findAll();
    void save(CourseInfo courseInfo);
    List<CourseInfo> findCourse(SearchCourseInfoParams serachCourseInfoParams);
    CourseInfo findCourseInfoByCourseId(String course_id);
}
