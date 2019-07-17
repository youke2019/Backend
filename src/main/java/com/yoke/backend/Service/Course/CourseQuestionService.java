package com.yoke.backend.Service.Course;

import com.yoke.backend.Entity.CourseMessage.CourseQuestion;

import javax.persistence.Id;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseQuestionService {
    List<CourseQuestion> findQuestionByCourse(String course_id,String user_id);
    void addQuestion(String course_id,String user_id,String question_content);
    void addAnswer(Integer question_id,String user_id,String answer_content);
    void praiseQuestion(Integer question_id,String user_id);
    void praiseAnswer(Integer answer_id,String user_id);
}
