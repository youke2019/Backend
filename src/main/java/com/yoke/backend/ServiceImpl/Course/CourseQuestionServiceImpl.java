package com.yoke.backend.ServiceImpl.Course;

import com.yoke.backend.Dao.CourseMessage.CourseAnswerDao;
import com.yoke.backend.Dao.CourseMessage.CourseQuestionDao;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestionPraise;
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

    @Autowired
    CourseAnswerDao courseAnswerDao;

    @Override
    public List<CourseQuestion> findQuestionByCourse(String course_id,String user_id)
    {
        List<CourseQuestion> courseQuestionList=courseQuestionDao.findQuestionByCourse(course_id);
        for(CourseQuestion courseQuestion:courseQuestionList)
        {
            for(CourseQuestionPraise courseQuestionPraise :courseQuestion.getCourseQuestionPraiseList())
            {
                if(courseQuestionPraise.getUser_id().equals(course_id))
                    courseQuestion.setCurrent_user_praise(true);
            }
            List<CourseAnswer> courseAnswerList=courseQuestion.getCourseAnswerList();
            for(CourseAnswer courseAnswer:courseAnswerList)
            {
                for(CourseAnswerPraise courseAnswerPraise:courseAnswer.getCourseAnswerPraiseList())
                {
                    if(courseAnswerPraise.getUser_id().equals(course_id))
                        courseAnswer.setCurrent_user_praise(true);
                }
            }
        }
        return courseQuestionList;
    }

    @Override
    public void addQuestion(String course_id,String user_id,String question_content)
    {
        CourseQuestion courseQuestion=new CourseQuestion(course_id, user_id, question_content);
        courseQuestionDao.save(courseQuestion);
    }
    @Override
    public void addAnswer(Integer question_id,String user_id,String answer_content)
    {
        CourseAnswer courseAnswer=new CourseAnswer(question_id,user_id,answer_content);
        courseAnswerDao.save(courseAnswer);
    }

    @Override
    public void praiseQuestion(Integer question_id,String user_id)
    {
        CourseQuestionPraise courseQuestionPraise=new CourseQuestionPraise(question_id,user_id);

    }

    @Override
    public void praiseAnswer(Integer answer_id,String user_id)
    {

    }
}
