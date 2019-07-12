package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.CourseCommentDao;
import com.yoke.backend.Entity.Comment.CourseComment;
import com.yoke.backend.Service.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
@Service
public class CourseCommentServiceImpl implements CourseCommentService {

    @Autowired
    CourseCommentDao courseCommentDao;

    @Override
    public List<CourseComment> allComment()
    {
        return courseCommentDao.findAll();
    }

    @Override
    public List<CourseComment> findCommentByCourse(String course_id)
    {
        return courseCommentDao.findCommentByCourse(course_id);
    }

    @Override
    public void userCommentCourse(CourseComment courseComment)
    {
        courseCommentDao.save(courseComment);
    }

    @Override
    public void withdrawCommentOfCourse(Integer comment_id)
    {
        courseCommentDao.delete(comment_id);
    }

    @Override
    public void banCommentOfCourse(Integer comment_id)
    {
        CourseComment courseComment=courseCommentDao.findCourseCommentById(comment_id);
        courseComment.setIsbanned(true);
        courseCommentDao.save(courseComment);
    }

    @Override
    public void unbanCommentOfCourse(Integer comment_id)
    {
        CourseComment courseComment=courseCommentDao.findCourseCommentById(comment_id);
        courseComment.setIsbanned(false);
        courseCommentDao.save(courseComment);
    }

}
