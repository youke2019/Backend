package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseMessageReportService {
    String reportQuestion(CourseQuestionReport courseQuestionReport);
    String reportAnswer(CourseAnswerReport courseAnswerReport);
    String reportComment(CourseCommentReport courseCommentReport);
    List<CourseAnswerReport> getAnswerReportsReported();
    List<CourseCommentReport> getCommentReportsReported();
    List<CourseQuestionReport> getQuestionReportsReported();
    List<CourseAnswerReport> getAnswerReportsHandled();
    List<CourseCommentReport> getCommentReportsHandled();
    List<CourseQuestionReport> getQuestionReportsHandled();
    Boolean handleAnswerReport(Integer answer_report_id, Integer handler);
    Boolean handleCommentReport(Integer comment_report_id, Integer handler);
    Boolean handleQuestionReport(Integer question_report_id, Integer handler);
}
