package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseEvaluateDao;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import com.yoke.backend.repository.CourseMessage.CourseEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Repository
public class CourseEvaluationDaoImpl implements CourseEvaluateDao {
    @Autowired
    CourseEvaluationRepository courseEvaluationRepository;

    public CourseEvaluation save(CourseEvaluation courseEvaluation)
    {
        return courseEvaluationRepository.saveAndFlush(courseEvaluation);
    }
    public List<CourseEvaluation> findByCourse(String course_id)
    {
        return courseEvaluationRepository.findByCourse(course_id);
    }

    public CourseEvaluation findById(Integer course_evaluate_id)
    {
        return courseEvaluationRepository.findById(course_evaluate_id).get();
    }

}
