package com.yoke.backend.Dao.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/8/31
 * @description:
 **/
public interface CourseMomentReportDao {
    void save(CourseMomentReport courseVideoReport);
    CourseMomentReport findById(Integer video_report_id);
    List<CourseMomentReport> findAllReported();
    List<CourseMomentReport> findAllHandled();
}
