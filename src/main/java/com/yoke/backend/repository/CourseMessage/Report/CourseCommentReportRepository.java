package com.yoke.backend.repository.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseCommentReportRepository extends JpaRepository<CourseCommentReport,Integer> {
    @Query(value="select * from course_comment_report where course_comment_report_ishandled=0",nativeQuery = true)
    List<CourseCommentReport> findCourseCommentReportsReported();

    @Query(value="select * from course_comment_report where course_comment_report_ishandled=1",nativeQuery = true)
    List<CourseCommentReport> findCourseCommentReportsHandled();
}
