package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Dao.CourseMessage.CourseQuestionDao;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestioinPraise;
import com.yoke.backend.Service.Course.CourseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Service
public class CourseQuestionServiceImpl implements CourseQuestionService {
    @Autowired
    CourseQuestionDao courseQuestionDao;

    @Override
    public List<CourseQuestion> findQuestionByCourse(String course_id,String user_id)
    {
        List<CourseQuestion> courseQuestionList=courseQuestionDao.findQuestionByCourse(course_id);
        for(CourseQuestion courseQuestion:courseQuestionList)
        {
            for(CourseQuestioinPraise courseQuestioinPraise:courseQuestion.getCourseQuestioinPraiseList())
            {
                if(courseQuestioinPraise.getUser_id().equals(course_id))
                    courseQuestion.setCurrentUserPraise(true);
            }
            List<CourseAnswer> courseAnswerList=courseQuestion.getCourseAnswerList();
            for(CourseAnswer courseAnswer:courseAnswerList)
            {
                for(CourseAnswerPraise courseAnswerPraise:courseAnswer.getCourseAnswerPraiseList())
                {
                    if(courseAnswerPraise)
                }
            }
        }
        return courseQuestionList;
    }

    @Override
    public void addQuestion(String course_id,String user_id,String question_content)
    {

    }
    @Override
    public void addAnswer(Integer question_id,String user_id,String answer_content)
    {

    }
    @Override
    public void praiseQuestion(Integer question_id,String user_id)
    {

    }
    @Override
    public void praiseAnswer(Integer answer_id,String user_id)
    {

    }
}
