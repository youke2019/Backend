package com.yoke.backend.Service.Course;

import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;

import java.io.IOException;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
public interface CourseService {
    void GetCourseFromJWC(String url,String cookies) throws IOException;
    List<CourseInfo> SearchCourseInfo(SearchCourseInfoParams searchCourseInfoParams);
    CourseInfo findCourseInfoByCourseId(String course_id);
    List<CourseInfo> updateCourseTable(String requestUrl, String Cookie) throws IOException;
    List<CourseInfo> findAll();
}
