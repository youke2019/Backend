package com.yoke.backend.DaoImpl.CourseMessage.Praise;

import com.yoke.backend.Dao.CourseMessage.Praise.CourseEvaluatePraiseDao;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import com.yoke.backend.repository.CourseMessage.Praise.CourseEvaluationPraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Repository
public class CourseEvaluatePraiseDaoImpl implements CourseEvaluatePraiseDao {
    @Autowired
    CourseEvaluationPraiseRepository courseEvaluationPraiseRepository;

    public void save(CourseEvaluationPraise courseEvaluationPraise)
    {
        courseEvaluationPraiseRepository.save(courseEvaluationPraise);
    }
    public void delete(Integer course_evaluate_id,String user_id)
    {
        courseEvaluationPraiseRepository.delete(course_evaluate_id,user_id);
    }
}
