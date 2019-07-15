package com.yoke.backend.repository.Praise;

import com.yoke.backend.Entity.Praise.CourseCommentPraise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
public interface CourseCommentPraiseRepository extends JpaRepository<CourseCommentPraise,Integer> {
    @Query(value="select * from course_comment_praise where ID=?1 and course_comment_id=?2 limit 1",nativeQuery = true)
    CourseCommentPraise findCourseCommentPraiseByUser_idAndCourse_comment_id(String user_id,Integer course_comment_id);
}
