package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.CourseDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import com.yoke.backend.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseInfo> findAll()
    {
        return courseRepository.findAll();
    }

    @Override
    public void save(CourseInfo courseInfo)
    {
        courseRepository.save(courseInfo);
    }

    @Override
    public List<CourseInfo> findCourse(SearchCourseInfoParams searchCourseInfoParams)
    {
        return courseRepository.findCourse(searchCourseInfoParams.getCourse_id(),
                searchCourseInfoParams.getCourse_name(),searchCourseInfoParams.getTeacher_name(),
                searchCourseInfoParams.getCourse_types(),searchCourseInfoParams.getGeneral_types(),
                searchCourseInfoParams.getWeekdays(),searchCourseInfoParams.getBegin_secs(),
                searchCourseInfoParams.getEnd_secs(),searchCourseInfoParams.getBuilding(),
                searchCourseInfoParams.getCourse_credits());
    }


}