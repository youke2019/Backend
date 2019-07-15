package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.CourseCommentDao;
import com.yoke.backend.Dao.Praise.CourseCommentPraiseDao;
import com.yoke.backend.Entity.Comment.CourseComment;
import com.yoke.backend.Entity.Praise.CourseCommentPraise;
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

    @Autowired
    CourseCommentPraiseDao courseCommentPraiseDao;

    @Override
    public List<CourseComment> allComment()
    {
        return courseCommentDao.findAll();
    }

    @Override
    public List<CourseComment> findCommentByCourse(String course_id)
    {
        List<CourseComment> courseComments=courseCommentDao.findCommentByCourse(course_id);
        for (int i=0;i<courseComments.size();++i)
        {
            courseComments.get(i).setCourseCommentPraises(null);
        }
        return courseComments;
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

    @Override
    public boolean praiseCourseComment(String user_id,Integer course_comemnt_id)
    {
        CourseCommentPraise courseCommentPraise=new CourseCommentPraise(user_id,course_comemnt_id);
        CourseComment courseComment=courseCommentDao.findCourseCommentById(course_comemnt_id);
        List<CourseCommentPraise> courseCommentPraises=courseComment.getCourseCommentPraises();
        courseCommentPraises.add(courseCommentPraise);
        courseComment.setCourseCommentPraises(courseCommentPraises);
        courseCommentDao.save(courseComment);
        return true;
    }

    @Override
    public boolean unpraiseCourseComment(String user_id,Integer course_comment_id)
    {
        CourseCommentPraise courseCommentPraise=courseCommentPraiseDao.findCourseCommentPraiseByUser_idAndCourse_comment_id(user_id, course_comment_id);
        courseCommentPraiseDao.deleteCourseCommentPraise(courseCommentPraise.getCourse_comment_praise_id());
        return true;
    }

}
