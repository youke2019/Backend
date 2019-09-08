package com.yoke.backend.DaoImpl.CourseMessage.Report;

import com.yoke.backend.Dao.CourseMessage.Report.CourseAnswerReportDao;
import com.yoke.backend.Entity.CourseMessage.Report.CourseAnswerReport;
import com.yoke.backend.repository.CourseMessage.Report.CourseAnswerReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Repository
public class CourseAnswerReportDaoImpl implements CourseAnswerReportDao {
    @Autowired
    CourseAnswerReportRepository courseAnswerReportRepository;

    @Override
    public void save(CourseAnswerReport courseAnswerReport)
    {
        courseAnswerReportRepository.save(courseAnswerReport);
    }

    @Override
    public CourseAnswerReport findById(Integer course_answer_report_id)
    {
        System.out.println("here");
        System.out.println(course_answer_report_id);
        return courseAnswerReportRepository.findById(course_answer_report_id).get();
    }

    @Override
    public List<CourseAnswerReport> findAllReported(){return courseAnswerReportRepository.findCourseAnswerReportsReported();}

    @Override
    public List<CourseAnswerReport> findAllHandled(){return courseAnswerReportRepository.findCourseAnswerReportsHandled();}
}
