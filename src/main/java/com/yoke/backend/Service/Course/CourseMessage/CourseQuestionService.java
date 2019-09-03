package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseQuestionService {
    List<CourseQuestion> findQuestionByCourse(String course_id,String user_id);
    CourseQuestion findQuestionById(Integer id);
    CourseAnswer findAnswerById(Integer id);
    void addQuestion(CourseQuestion courseQuestion);
    void addAnswer(CourseAnswer courseAnswer);
    void praiseQuestion(Integer question_id,String user_id);
    void praiseAnswer(Integer answer_id,String user_id);
    void unpraiseQuestion(Integer question_id,String user_id);
    void unpraiseAnswer(Integer answer_id,String user_id);
}
