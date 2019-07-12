package com.yoke.backend.Dao;

import com.yoke.backend.Entity.Comment.CourseComment;

import javax.xml.stream.events.Comment;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
public interface CourseCommentDao {
    List<CourseComment> findAll();
    void save(CourseComment courseCcomment);
    void delete(Integer course_comment_id);
    List<CourseComment> findCommentByCourse(String course_id);
    CourseComment findCourseCommentById(Integer comment_id);
}
