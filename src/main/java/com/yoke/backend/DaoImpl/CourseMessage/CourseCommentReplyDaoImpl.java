package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseCommentDao;
import com.yoke.backend.Dao.CourseMessage.CourseCommentReplyDao;
import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import com.yoke.backend.repository.CourseMessage.CourseCommentReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Repository
public class CourseCommentReplyDaoImpl implements CourseCommentReplyDao {

    @Autowired
    CourseCommentReplyRepository courseCommentReplyRepository;

    public void save(CourseCommentReply courseCommentReply)
    {
        courseCommentReplyRepository.save(courseCommentReply);
    }
}
