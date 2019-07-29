package com.yoke.backend.Service.Course;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
public interface CourseRecommendService {
    List<RecommendedItem> userBasedRecommend(long user_id,Integer size) throws TasteException;
}
