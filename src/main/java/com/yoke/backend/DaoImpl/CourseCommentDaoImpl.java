package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.CourseCommentDao;
import com.yoke.backend.Entity.Comment.CourseComment;
import com.yoke.backend.repository.CourseCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/

@Repository
public class CourseCommentDaoImpl implements CourseCommentDao {
    @Autowired
    CourseCommentRepository courseCommentRepository;

    @Override
    public List<CourseComment> findAll()
    {
        return courseCommentRepository.findAll();
    }

    @Override
    public List<CourseComment> findCommentByCourse(String course_id)
    {
        return courseCommentRepository.findCommentByCourse(course_id);
    }

    @Override
    public void save(CourseComment courseCcomment)
    {
        courseCommentRepository.save(courseCcomment);
    }

    @Override
    public void delete(Integer comment_id)
    {
        courseCommentRepository.deleteById(comment_id);
    }

    @Override
    public CourseComment findCourseCommentById(Integer comment_id)
    {
        return courseCommentRepository.findById(comment_id).get();
    }

}
