package com.yoke.backend.DaoImpl.CourseMessage.Praise;

import com.yoke.backend.Dao.CourseMessage.Praise.CourseQuestionPraiseDao;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestionPraise;
import com.yoke.backend.repository.CourseMessage.Praise.CourseQuestionPraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Repository
public class CourseQuestionPraiseDaoImpl implements CourseQuestionPraiseDao {
    @Autowired
    CourseQuestionPraiseRepository courseQuestionPraiseRepository;

    @Override
    public void save(CourseQuestionPraise courseQuestionPraise)
    {
        courseQuestionPraiseRepository.save(courseQuestionPraise);
    }

    @Override
    public void delete(Integer question_id,String user_id)
    {
        courseQuestionPraiseRepository.delete(question_id,user_id);
    }
}
