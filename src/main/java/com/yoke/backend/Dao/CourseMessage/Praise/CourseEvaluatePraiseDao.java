package com.yoke.backend.Dao.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
public interface CourseEvaluatePraiseDao {
    void save(CourseEvaluationPraise courseEvaluationPraise);
    void delete(Integer course_evaluate_id,String user_id);

}
