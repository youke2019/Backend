package com.yoke.backend.DaoImpl.CourseMessage.Report;

import com.yoke.backend.Dao.CourseMessage.Report.CourseQuestionReportDao;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseQuestionReport;
import com.yoke.backend.repository.CourseMessage.Report.CourseQuestionReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Repository
public class CourseQuestionReportDaoImpl implements CourseQuestionReportDao {

    @Autowired
    CourseQuestionReportRepository courseQuestionReportRepository;

    @Override
    public void save(CourseQuestionReport courseQuestionReport)
    {
        courseQuestionReportRepository.save(courseQuestionReport);
    }

    @Override
    public CourseQuestionReport findById(Integer course_question_report_id)
    {
        return courseQuestionReportRepository.findById(course_question_report_id).get();
    }

    @Override
    public List<CourseQuestionReport> findAllReported(){return courseQuestionReportRepository.findCourseQuestionReportsReported();}

    @Override
    public List<CourseQuestionReport> findAllHandled(){return courseQuestionReportRepository.findCourseQuestionReportsHandled();}
}
