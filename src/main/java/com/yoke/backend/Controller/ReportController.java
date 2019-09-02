package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import com.yoke.backend.Service.Course.CourseMessage.CourseReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/report")
public class ReportController {
    @Autowired
    CourseReportService courseReportService;

    /**
     *@api {post} /report/report/comment
     *@apiDescription 举报课程评论
     *@apiName reportComment
     *@apiGroup report
     *@apiVersion 1.0.0
     *@apiSampleRequest 47.103.30.166:8000/report/report/comment
     *@apiSuccessExample Post-Example:
     *     {
     *
     *     "course_comment_id":9,
     *     "user_id"：84514，
     *     "course_comment_report_reason":"污蔑老师"
     * }
     *
     * @param courseCommentReport
     * @return
     */
    @RequestMapping(value = "/report/comment", method = RequestMethod.POST)
    public String reportComment(@RequestBody CourseCommentReport courseCommentReport) {
       courseReportService.reportComment(courseCommentReport);
       return "success";
    }

    /**
     *@api {post} /report/report/answer
     *@apiDescription 举报课程回答
     *@apiName reportAnswer
     *@apiGroup report
     *@apiVersion 1.0.0
     *@apiSampleRequest 47.103.30.166:8000/report/report/answer
     *@apiSuccessExample Post-Example:
     *     {
     *
     *     "answer_id":9,
     *     "user_id"：84514，
     *     "answer_report_reason":"污蔑老师"
     * }
     *
     * @param courseAnswerReport
     * @return
     */
    @RequestMapping(value = "/report/answer", method = RequestMethod.POST)
    public String reportAnswer(@RequestBody CourseAnswerReport courseAnswerReport) {
        courseReportService.reportAnswer(courseAnswerReport);
        return "success";
    }
    /**
     *@api {post} /report/report/question
     *@apiDescription 举报课程问题
     *@apiName reportQuestion
     *@apiGroup report
     *@apiVersion 1.0.0
     *@apiSampleRequest 47.103.30.166:8000/report/report/question
     *@apiSuccessExample Post-Example:
     *     {
     *     "question_id":9,
     *     "user_id":84514，
     *     "question_report_reason":"污蔑老师"
     * }
     *
     * @param courseQuestionReport
     * @return
     */
    @RequestMapping(value = "/report/question", method = RequestMethod.POST)
    public String reportQuestion(@RequestBody CourseQuestionReport courseQuestionReport) {
        courseReportService.reportQuestion(courseQuestionReport);
        return "success";
    }

    /**
     *@api {post} /report/report/moment
     *@apiDescription 举报课程精彩瞬间
     *@apiName reportMoment
     *@apiGroup report
     *@apiVersion 1.0.0
     *@apiSampleRequest 47.103.30.166:8000/report/report/moment
     *@apiSuccessExample Post-Example:
     *     {
     *
     *     "video_id":9,
     *     "user_id"：84514，
     *     "video_report_reason":"污蔑老师"
     * }
     * @param courseMomentReport
     */
    @RequestMapping(value = "/report/moment",method = RequestMethod.POST)
    public String  reportMoment(@RequestBody CourseMomentReport courseMomentReport)
    {
        courseReportService.reportMoment(courseMomentReport);
        return "success";
    }

    @RequestMapping(value = "/getHandled/comments", method = RequestMethod.GET)
    public List<CourseCommentReport> getHandledComments (){
        return courseReportService.getCommentReportsHandled();
    }
    @RequestMapping(value = "/getHandled/answers", method = RequestMethod.GET)
    public List<CourseAnswerReport> getHandledAnswers (){
        return courseReportService.getAnswerReportsHandled();
    }
    @RequestMapping(value = "/getHandled/questions", method = RequestMethod.GET)
    public List<CourseQuestionReport> getHandledQuestions (){
        return courseReportService.getQuestionReportsHandled();
    }
    @RequestMapping(value = "/getHandled/moments",method = RequestMethod.GET)
    public List<CourseMomentReport> getHanledMoments(){
        return courseReportService.getMomentReportsHandled();
    }

    @RequestMapping(value = "/getReported/comments", method = RequestMethod.GET)
    public List<CourseCommentReport> getReportedComments (){
        return courseReportService.getCommentReportsReported();
    }
    @RequestMapping(value = "/getReported/answers", method = RequestMethod.GET)
    public List<CourseAnswerReport> getReportedAnswers (){
        return courseReportService.getAnswerReportsReported();
    }
    @RequestMapping(value = "/getReported/questions", method = RequestMethod.GET)
    public List<CourseQuestionReport> getReportedQuestions (){
        return courseReportService.getQuestionReportsReported();
    }
    @RequestMapping(value = "/getReported/moments",method = RequestMethod.GET)
    public List<CourseMomentReport> getReportedMoments(){
        return courseReportService.getMomentReportsReported();
    }

    @RequestMapping(value = "/handle/comment", method = RequestMethod.GET)
    public Boolean handleComment(@RequestParam Integer course_comment_report_id,@RequestParam Integer handler) {
        return courseReportService.handleCommentReport(course_comment_report_id, handler);
    }
    @RequestMapping(value = "/handle/answer", method = RequestMethod.GET)
    public Boolean handleAnswer(@RequestParam Integer course_answer_report_id,@RequestParam Integer handler) {
        return courseReportService.handleCommentReport(course_answer_report_id, handler);
    }
    @RequestMapping(value = "/handle/question", method = RequestMethod.GET)
    public Boolean handleQuestion(@RequestParam Integer course_question_report_id,@RequestParam Integer handler) {
        return courseReportService.handleCommentReport(course_question_report_id, handler);
    }

    /**
     *
     * @param report_id
     * @param handler
     * @return
     */
    @RequestMapping(value = "/handle/moment",method = RequestMethod.GET)
    public Boolean handleMoment(Integer report_id,Integer handler)
    {
        return courseReportService.handleMomentReport(report_id, handler);
    }
}
