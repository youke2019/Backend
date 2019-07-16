package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseEvaluationDao;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.repository.CourseMessage.CourseEvaluateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
@Repository
public class CourseEvaluationDaoImpl implements CourseEvaluationDao {
    @Autowired
    CourseEvaluateRepository courseEvaluateRepository;

    @Override
    public void save(CourseEvaluation courseEvaluation)
    {
        courseEvaluateRepository.save(courseEvaluation);
    }

    @Override
    public List<CourseEvaluation> findByCourseId(String course_id)
    {
        return courseEvaluateRepository.findByCourseId(course_id);
    }

    @Override
    public void delete(Integer course_evaluate_id)
    {
        courseEvaluateRepository.deleteById(course_evaluate_id);
    }

    @Override
    public CourseEvaluation findByCourseIdAndUserId(String course_id,String user_id)
    {
        return courseEvaluateRepository.findByCourseIdAndUserId(course_id,user_id);
    }
}
