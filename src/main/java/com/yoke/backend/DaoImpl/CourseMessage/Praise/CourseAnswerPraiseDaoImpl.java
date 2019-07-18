package com.yoke.backend.DaoImpl.CourseMessage.Praise;

import com.yoke.backend.Dao.CourseMessage.Praise.CourseAnswerPraiseDao;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import com.yoke.backend.repository.CourseMessage.Praise.CourseAnswerPraiseRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Repository
public class CourseAnswerPraiseDaoImpl implements CourseAnswerPraiseDao {

    @Autowired
    CourseAnswerPraiseRepositroy courseAnswerPraiseRepositroy;

    @Override
    public void save(CourseAnswerPraise courseAnswerPraise)
    {
        courseAnswerPraiseRepositroy.save(courseAnswerPraise);
    }
}
