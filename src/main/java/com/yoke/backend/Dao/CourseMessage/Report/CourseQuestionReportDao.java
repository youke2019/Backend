package com.yoke.backend.Dao.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseQuestionReportDao {
    void save(CourseQuestionReport courseQuestionReport);
    CourseQuestionReport findById(Integer course_comment_report_id);
    List<CourseQuestionReport>  findAllReported();
    List<CourseQuestionReport>  findAllHandled();
}
