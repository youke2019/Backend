package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import com.yoke.backend.Service.Course.CourseMessage.CourseMessageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
    @Autowired
    CourseMessageReportService courseMessageReportService;

    @RequestMapping(value = "/report/comment", method = RequestMethod.POST)
    public void reportComment(@RequestBody CourseCommentReport courseCommentReport) {
       courseMessageReportService.reportComment(courseCommentReport);
    }
    @RequestMapping(value = "/report/answer", method = RequestMethod.POST)
    public void reportAnswer(@RequestBody CourseAnswerReport courseAnswerReport) {
        courseMessageReportService.reportAnswer(courseAnswerReport);
    }
    @RequestMapping(value = "/report/question", method = RequestMethod.POST)
    public void reportQuestion(@RequestBody CourseQuestionReport courseQuestionReport) {
        courseMessageReportService.reportQuestion(courseQuestionReport);
    }

    @RequestMapping(value = "/getHandled/comments", method = RequestMethod.GET)
    public List<CourseCommentReport> getHandledComments (){
        return courseMessageReportService.getCommentReportsHandled();
    }
    @RequestMapping(value = "/getHandled/answers", method = RequestMethod.GET)
    public List<CourseAnswerReport> getHandledAnswers (){
        return courseMessageReportService.getAnswerReportsHandled();
    }
    @RequestMapping(value = "/getHandled/questions", method = RequestMethod.GET)
    public List<CourseQuestionReport> getHandledQuestions (){
        return courseMessageReportService.getQuestionReportsHandled();
    }

    @RequestMapping(value = "/getReported/comments", method = RequestMethod.GET)
    public List<CourseCommentReport> getReportedComments (){
        return courseMessageReportService.getCommentReportsReported();
    }
    @RequestMapping(value = "/getReported/answers", method = RequestMethod.GET)
    public List<CourseAnswerReport> getReportedAnswers (){
        return courseMessageReportService.getAnswerReportsReported();
    }
    @RequestMapping(value = "/getReported/questions", method = RequestMethod.GET)
    public List<CourseQuestionReport> getReportedQuestions (){
        return courseMessageReportService.getQuestionReportsReported();
    }

    @RequestMapping(value = "/handle/comment", method = RequestMethod.GET)
    public Boolean handleComment(@RequestParam Integer course_comment_report_id,@RequestParam Integer handler) {
        return courseMessageReportService.handleCommentReport(course_comment_report_id, handler);
    }
    @RequestMapping(value = "/handle/answer", method = RequestMethod.GET)
    public Boolean handleAnswer(@RequestParam Integer course_answer_report_id,@RequestParam Integer handler) {
        return courseMessageReportService.handleCommentReport(course_answer_report_id, handler);
    }
    @RequestMapping(value = "/handle/question", method = RequestMethod.GET)
    public Boolean handleQuestion(@RequestParam Integer course_question_report_id,@RequestParam Integer handler) {
        return courseMessageReportService.handleCommentReport(course_question_report_id, handler);
    }
}
