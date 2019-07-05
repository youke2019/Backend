package com.yoke.backend.Service;

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
}
