package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseMomentCommentDao;
import com.yoke.backend.Entity.CourseMessage.CourseMomentComment;
import com.yoke.backend.repository.CourseMessage.CourseMomentCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Repository
public class CourseMomentCommentDaoImpl implements CourseMomentCommentDao {
    @Autowired
    CourseMomentCommentRepository courseMomentCommentRepository;

    @Override
    public void save(CourseMomentComment courseMomentComment)
    {
        courseMomentCommentRepository.save(courseMomentComment);
    }
}
