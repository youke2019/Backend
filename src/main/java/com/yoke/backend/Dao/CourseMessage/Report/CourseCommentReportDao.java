package com.yoke.backend.Dao.CourseMessage.Report;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseCommentReportDao {
    void save(CourseCommentReport courseCommentReport);
    CourseCommentReport findById(Integer course_comment_report_id);
    List<CourseCommentReport>  findAllReported();
    List<CourseCommentReport>  findAllHandled();
}
