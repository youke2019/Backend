package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseAnswerDao;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.repository.CourseMessage.CourseAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Repository
public class CourseAnswerDaoImpl implements CourseAnswerDao {
    @Autowired
    CourseAnswerRepository courseAnswerRepository;

    public void save(CourseAnswer courseAnswer)
    {
        courseAnswerRepository.save(courseAnswer);
    }
}
