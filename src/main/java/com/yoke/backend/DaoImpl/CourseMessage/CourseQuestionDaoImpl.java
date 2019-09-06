package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseQuestionDao;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.repository.CourseMessage.CourseQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Repository
public class CourseQuestionDaoImpl implements CourseQuestionDao {
    @Autowired
    CourseQuestionRepository courseQuestionRepository;

    @Override
    public List<CourseQuestion> findQuestionByCourse(String course_id)
    {
        return courseQuestionRepository.findQuestionByCourse(course_id);
    }

    @Override
    public void save(CourseQuestion courseQuestion)
    {
        System.out.println(courseQuestion.getQuestion_content());
        courseQuestionRepository.save(courseQuestion);
    }

    @Override
    public CourseQuestion findQuestionById(Integer question_id)
    {
         return courseQuestionRepository.findById(question_id).get();
    }

}
