package com.yoke.backend.Dao.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
public interface CourseAnswerDao  {
    void save(CourseAnswer courseAnswer);
    CourseAnswer findAnswerById(Integer answer_id);

    /**
     * @AUTHOR: Guozhi
     * @DATE : 2019/7/15
     * @description:
     **/
    interface CourseCommentPraiseDao {
        CourseCommentPraise findCourseCommentPraiseByUser_idAndCourse_comment_id(String user_id, Integer course_comment_id);
        void deleteCourseCommentPraise(Integer course_comment_praise_id);
    }
}
