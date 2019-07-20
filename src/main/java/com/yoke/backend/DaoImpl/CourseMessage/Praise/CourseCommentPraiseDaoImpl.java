package com.yoke.backend.DaoImpl.CourseMessage.Praise;

import com.yoke.backend.Dao.CourseMessage.Praise.CourseCommentPraiseDao;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;
import com.yoke.backend.repository.CourseMessage.Praise.CourseCommentPraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
@Repository
public class CourseCommentPraiseDaoImpl implements CourseCommentPraiseDao {

    @Autowired
    CourseCommentPraiseRepository courseCommentPraiseRepository;

    @Override
    public CourseCommentPraise findCourseCommentPraiseByUser_idAndCourse_comment_id(String user_id, Integer course_comment_id)
    {
        CourseCommentPraise courseCommentPraise=courseCommentPraiseRepository.findCourseCommentPraiseByUser_idAndCourse_comment_id(user_id, course_comment_id);
        return  courseCommentPraise;
    }

    @Override
    public void deleteCourseCommentPraise(Integer course_comment_praise_id)
    {
        courseCommentPraiseRepository.deleteById(course_comment_praise_id);
    }

}
