package com.yoke.backend.repository.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseQuestionReportRepository extends JpaRepository<CourseQuestionReport,Integer> {
    @Query(value="select * from question_report where question_report_ishandled=0",nativeQuery = true)
    List<CourseQuestionReport> findCourseQuestionReportsReported();

    @Query(value="select * from question_report where question_report_ishandled=1",nativeQuery = true)
    List<CourseQuestionReport> findCourseQuestionReportsHandled();
}
