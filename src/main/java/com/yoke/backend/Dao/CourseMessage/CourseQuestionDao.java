package com.yoke.backend.Dao.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseQuestion;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseQuestionDao {
    List<CourseQuestion> findQuestionByCourse(String course_id);
    void save(CourseQuestion courseQuestion);
    CourseQuestion findQuestionById(Integer question_id);
}
