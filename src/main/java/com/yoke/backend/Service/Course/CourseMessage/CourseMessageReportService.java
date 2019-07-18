package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
public interface CourseMessageReportService {
    String reportQuestion(CourseQuestionReport courseQuestionReport);
    String reportAnswer(CourseAnswerReport courseAnswerReport);
    String reportComment(CourseCommentReport courseCommentReport);
}
