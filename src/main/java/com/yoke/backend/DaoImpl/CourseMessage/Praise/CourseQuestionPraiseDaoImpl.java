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

    public void save(CourseQuestionPraise courseQuestionPraise)
    {
        courseQuestionPraiseRepository.save(courseQuestionPraise);
    }
}
