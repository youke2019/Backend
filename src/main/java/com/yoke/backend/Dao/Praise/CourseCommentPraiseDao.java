package com.yoke.backend.Dao.Praise;

import com.yoke.backend.Entity.Praise.CourseCommentPraise;


/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
public interface CourseCommentPraiseDao {
    CourseCommentPraise findCourseCommentPraiseByUser_idAndCourse_comment_id(String user_id,Integer course_comment_id);
    void deleteCourseCommentPraise(Integer course_comment_praise_id);
}
