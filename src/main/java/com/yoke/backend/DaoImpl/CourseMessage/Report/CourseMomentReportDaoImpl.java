package com.yoke.backend.DaoImpl.CourseMessage.Report;

import com.yoke.backend.Dao.CourseMessage.Report.CourseMomentReportDao;
import com.yoke.backend.Entity.CourseMessage.Report.CourseMomentReport;
import com.yoke.backend.repository.CourseMessage.Report.CourseMomentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/8/31
 * @description:
 **/
@Repository
public class CourseMomentReportDaoImpl  implements CourseMomentReportDao {

    @Autowired
    CourseMomentReportRepository courseMomentReportRepository;

    @Override
    public void save(CourseMomentReport courseMomentReport)
    {
        courseMomentReportRepository.save(courseMomentReport);
    }

    @Override
    public CourseMomentReport findById(Integer video_report_id)
    {
        return courseMomentReportRepository.findById(video_report_id).get();
    }

    @Override
    public List<CourseMomentReport> findAllReported()
    {
        return courseMomentReportRepository.findCourseMomentReportsReported();
    }

    @Override
    public List<CourseMomentReport> findAllHandled()
    {
        return courseMomentReportRepository.findCourseMommentReportsHandled();
    }
}
