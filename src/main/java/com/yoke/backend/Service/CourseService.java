package com.yoke.backend.Service;

import java.io.IOException;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
public interface CourseService {
    void GetCourseFromJWC(String url,String cookies) throws IOException;
}
