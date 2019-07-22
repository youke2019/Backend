package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseAnswerDao;
import com.yoke.backend.Dao.CourseMessage.CourseCommentDao;
import com.yoke.backend.Dao.CourseMessage.CourseCommentReplyDao;
import com.yoke.backend.Dao.CourseMessage.Praise.CourseCommentPraiseDao;
import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;
import com.yoke.backend.Service.Course.CourseMessage.CourseCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OneToMany;
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

    @Autowired
    CourseCommentReplyDao courseCommentReplyDao;

    @Override
    public List<CourseComment> allComment()
    {
        return courseCommentDao.findAll();
    }

    @Override
    public List<CourseComment> findCommentByCourse(String course_id,String user_id)
    {
        List<CourseComment> courseComments=courseCommentDao.findCommentByCourse(course_id);
        for (int i=0;i<courseComments.size();++i)
        {
            for(CourseCommentPraise courseCommentPraise:courseComments.get(i).getCourseCommentPraises())
            {
                if(courseCommentPraise.getUser_id().equals(user_id))
                {
                    courseComments.get(i).setCurrent_user_praise(true);
                }
            }
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
        courseComment.setCourse_comment_praise_point(courseComment.getCourse_comment_praise_point()+1);
        courseCommentDao.save(courseComment);
        return true;
    }

    @Override
    public boolean unpraiseCourseComment(String user_id,Integer course_comment_id)
    {
        CourseCommentPraise courseCommentPraise=courseCommentPraiseDao.findCourseCommentPraiseByUser_idAndCourse_comment_id(user_id, course_comment_id);
        courseCommentPraiseDao.deleteCourseCommentPraise(courseCommentPraise.getCourse_comment_praise_id());
        CourseComment courseComment=courseCommentDao.findCourseCommentById(course_comment_id);
        courseComment.setCourse_comment_praise_point(courseComment.getCourse_comment_praise_point()-1);
        courseCommentDao.save(courseComment);
        return true;
    }

    @Override
    public String replyCourseComment(CourseCommentReply courseCommentReply)
    {
        if(courseCommentReply.getCourse_comment_id()==null||courseCommentReply.getUser_id()==null)
        {
            return "param is not correct";
        }

        courseCommentReplyDao.save(courseCommentReply);
        return "success";
    }

}
