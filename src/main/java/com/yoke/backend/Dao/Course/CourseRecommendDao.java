package com.yoke.backend.Dao.Course;

import com.yoke.backend.Entity.Course.CourseRecommendModel;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
public interface CourseRecommendDao  {
    void save(CourseRecommendModel courseRecommendModel);
    List<CourseRecommendModel> findAll();
}
