package com.yoke.backend.repository.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
public interface CourseCommentRepository extends JpaRepository<CourseComment,Integer>{
    @Query(value="select * from course_comment where course_id=?1",nativeQuery = true)
    List<CourseComment> findCommentByCourse(String course_id);

}
