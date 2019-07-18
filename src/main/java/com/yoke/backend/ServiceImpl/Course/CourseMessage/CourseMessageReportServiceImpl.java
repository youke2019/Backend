package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.Report.CourseAnswerReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseCommentReportDao;
import com.yoke.backend.Dao.CourseMessage.Report.CourseQuestionReportDao;
import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import com.yoke.backend.Service.Course.CourseMessage.CourseMessageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    CourseAnswerReportDao courseAnswerReportDao;
    @Autowired
    CourseQuestionReportDao courseQuestionReportDao;

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
}
