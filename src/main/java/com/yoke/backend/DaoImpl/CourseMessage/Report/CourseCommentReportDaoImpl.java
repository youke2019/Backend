package com.yoke.backend.DaoImpl.CourseMessage.Report;

import com.yoke.backend.Dao.CourseMessage.Report.CourseCommentReportDao;
import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.repository.CourseMessage.Report.CourseCommentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Repository
public class CourseCommentReportDaoImpl implements CourseCommentReportDao {
    @Autowired
    CourseCommentReportRepository courseCommentReportRepository;

    @Override
    public void save(CourseCommentReport courseCommentReport)
    {
        courseCommentReportRepository.save(courseCommentReport);
    }

    @Override
    public CourseCommentReport findById(Integer course_comment_report_id)
    {
        return courseCommentReportRepository.findById(course_comment_report_id).get();
    }

    @Override
    public List<CourseCommentReport> findAllReported(){return courseCommentReportRepository.findCourseCommentReportsReported();}

    @Override
    public List<CourseCommentReport> findAllHandled(){return courseCommentReportRepository.findCourseCommentReportsHandled();}
}
