package com.yoke.backend.Dao.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseAnswerReportDao {
    void save(CourseAnswerReport courseAnswerReport);
    CourseAnswerReport findById(Integer course_answer_report_id);
    List<CourseAnswerReport>  findAllReported();
    List<CourseAnswerReport>  findAllHandled();
}
