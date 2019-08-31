package com.yoke.backend.repository.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/8/31
 * @description:
 **/
public interface CourseMomentReportRepository extends JpaRepository<CourseMomentReport,Integer> {
    @Query(value="select * from video_report where video_report_ishandled=0",nativeQuery = true)
    List<CourseMomentReport> findCourseMomentReportsReported();

    @Query(value="select * from video_report where video_report_ishandled=1",nativeQuery = true)
    List<CourseMomentReport> findCourseMommentReportsHandled();
}
