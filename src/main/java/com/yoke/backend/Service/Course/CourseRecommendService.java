package com.yoke.backend.Service.Course;

import com.yoke.backend.Entity.Course.CourseInfo;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
public interface CourseRecommendService {
    List<RecommendedItem> userBasedRecommend(String user_id,Integer size);
    List<CourseInfo> popularRecommend(String user_id,Integer size);
    List<CourseInfo> courseRecommend(String user_id,Integer size);
    void saveDataModel(String user_id,String course_id,Integer evaluate_point);
    String generateData();
}
