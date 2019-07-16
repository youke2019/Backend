package com.yoke.backend.Service.Course;

import com.yoke.backend.Entity.CourseMessage.CourseComment;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
public interface CourseCommentService {
    List<CourseComment> allComment();
    List<CourseComment> findCommentByCourse(String course_id);
    void userCommentCourse(CourseComment courseComment);
    void withdrawCommentOfCourse(Integer comment_id);
    void banCommentOfCourse(Integer comment_id);
    void unbanCommentOfCourse(Integer comment_id);
    boolean praiseCourseComment(String user_id,Integer course_comment_id);
    boolean unpraiseCourseComment(String user_id,Integer course_comment_id);
}
