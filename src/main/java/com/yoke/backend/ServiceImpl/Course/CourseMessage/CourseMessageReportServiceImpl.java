package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseAnswerDao;
import com.yoke.backend.Dao.CourseMessage.CourseCommentDao;
import com.yoke.backend.Dao.CourseMessage.CourseQuestionDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseAnswerReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseCommentReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseQuestionReportDao;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import com.yoke.backend.Service.Course.CourseMessage.CourseMessageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Service
public class CourseMessageReportServiceImpl implements CourseMessageReportService {

    @Autowired
    CourseCommentReportDao courseCommentReportDao;
    @Autowired
    CourseCommentDao courseCommentDao;
    @Autowired
    CourseAnswerReportDao courseAnswerReportDao;
    @Autowired
    CourseAnswerDao courseAnswerDao;
    @Autowired
    CourseQuestionReportDao courseQuestionReportDao;
    @Autowired
    CourseQuestionDao courseQuestionDao;

    @Override
    public String reportQuestion(CourseQuestionReport courseQuestionReport)
    {
        courseQuestionReportDao.save(courseQuestionReport);
        return "success";
    }

    @Override
    public String reportAnswer(CourseAnswerReport courseAnswerReport)
    {
        courseAnswerReportDao.save(courseAnswerReport);
        return "success";
    }

    @Override
    public String reportComment(CourseCommentReport courseCommentReport)
    {
        courseCommentReportDao.save(courseCommentReport);
        return "success";
    }

    @Override
    public List<CourseAnswerReport> getAnswerReportsReported(){ return courseAnswerReportDao.findAllReported();}

    @Override
    public List<CourseCommentReport> getCommentReportsReported(){return courseCommentReportDao.findAllReported();}

    @Override
    public List<CourseQuestionReport> getQuestionReportsReported(){return courseQuestionReportDao.findAllReported();}

    @Override
    public List<CourseAnswerReport> getAnswerReportsHandled(){return courseAnswerReportDao.findAllHandled();}

    @Override
    public List<CourseCommentReport> getCommentReportsHandled(){return courseCommentReportDao.findAllHandled();}

    @Override
    public List<CourseQuestionReport> getQuestionReportsHandled(){return courseQuestionReportDao.findAllHandled();}

    @Override
    public Boolean handleAnswerReport(Integer answer_report_id, Integer handler){
        CourseAnswerReport courseAnswerReport = courseAnswerReportDao.findById(answer_report_id);
        courseAnswerReport.setAnswer_report_ishandled(1);
        Integer tmpInt = courseAnswerReport.getAnswer_id();
        CourseAnswer courseAnswer = courseAnswerDao.findAnswerById(tmpInt);
        Boolean tmp = handler == 1 ;
        courseAnswer.setAnswer_isbanned(tmp);
        courseAnswerDao.save(courseAnswer);
        courseAnswerReportDao.save(courseAnswerReport);
        return courseAnswerDao.findAnswerById(tmpInt).getAnswer_isbanned();
    }

    @Override
    public Boolean handleCommentReport(Integer comment_report_id, Integer handler){
        CourseCommentReport courseCommentReport = courseCommentReportDao.findById(comment_report_id);
        courseCommentReport.setCourse_comment_report_ishandled(1);
        Integer tmpInt = courseCommentReport.getCourse_comment_id();
        CourseComment courseComment = courseCommentDao.findCourseCommentById(tmpInt);
        Boolean tmp = handler == 1 ;
        courseComment.setIsbanned(tmp);
        courseCommentDao.save(courseComment);
        courseCommentReportDao.save(courseCommentReport);
        return courseCommentDao.findCourseCommentById(tmpInt).getIsbanned();
    }

    @Override
    public Boolean handleQuestionReport(Integer question_report_id, Integer handler){
        CourseQuestionReport courseQuestionReport = courseQuestionReportDao.findById(question_report_id);
        courseQuestionReport.setQuestion_report_ishandled(1);
        Integer tmpInt = courseQuestionReport.getQuestion_id();
        CourseQuestion courseQuestion = courseQuestionDao.findQuestionById(tmpInt);
        Boolean tmp = handler == 1;
        courseQuestion.setQuestion_isbanned(tmp);
        courseQuestionDao.save(courseQuestion);
        courseQuestionReportDao.save(courseQuestionReport);
        return courseQuestionDao.findQuestionById(tmpInt).getQuestion_isbanned();
    }
}
