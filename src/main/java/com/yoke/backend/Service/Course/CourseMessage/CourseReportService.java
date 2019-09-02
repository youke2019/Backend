package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseReportService {

    /**
     * functions for client to report message of course
     * @param courseQuestionReport
     * @return
     */
    String reportQuestion(CourseQuestionReport courseQuestionReport);
    String reportAnswer(CourseAnswerReport courseAnswerReport);
    String reportComment(CourseCommentReport courseCommentReport);
    String reportMoment(CourseMomentReport courseMomentReport);

    /**
     * funcions for manager to view the reported or handled messages of courses
     * @return
     */
    List<CourseAnswerReport> getAnswerReportsReported();
    List<CourseCommentReport> getCommentReportsReported();
    List<CourseQuestionReport> getQuestionReportsReported();
    List<CourseMomentReport> getMomentReportsReported();
    List<CourseAnswerReport> getAnswerReportsHandled();
    List<CourseCommentReport> getCommentReportsHandled();
    List<CourseQuestionReport> getQuestionReportsHandled();
    List<CourseMomentReport> getMomentReportsHandled();

    /**
     * functions for manager to handle reported courses' messages
     * @param answer_report_id
     * @param handler
     * @return
     */
    Boolean handleAnswerReport(Integer answer_report_id, Integer handler);
    Boolean handleCommentReport(Integer comment_report_id, Integer handler);
    Boolean handleQuestionReport(Integer question_report_id, Integer handler);
    Boolean handleMomentReport(Integer video_report_id,Integer handler);
}
