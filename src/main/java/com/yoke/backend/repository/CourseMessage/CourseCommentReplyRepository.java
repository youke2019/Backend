package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
public interface CourseCommentReplyRepository extends JpaRepository<CourseCommentReply,Integer> {
}
