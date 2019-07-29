package com.yoke.backend.Service.Course;

import com.yoke.backend.Entity.Course.CourseInfo;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
public interface CourseRecommendService {
    List<CourseInfo> userBasedRecommend(String user_id);
}
