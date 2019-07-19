package com.yoke.backend.repository.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseAnswerReportRepository extends JpaRepository<CourseAnswerReport,Integer> {
    @Query(value="select * from answer_report where answer_report_ishandled=0",nativeQuery = true)
    List<CourseAnswerReport> findCourseAnswerReportsReported();

    @Query(value="select * from answer_report where answer_report_ishandled=1",nativeQuery = true)
    List<CourseAnswerReport> findCourseAnswerReportsHandled();
}
