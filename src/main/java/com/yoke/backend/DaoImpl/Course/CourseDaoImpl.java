package com.yoke.backend.DaoImpl.Course;

import com.yoke.backend.Dao.Course.CourseDao;
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
        List<CourseInfo> courseInfoList= courseRepository.findCourse(searchCourseInfoParams.getCourse_id(),
                searchCourseInfoParams.getCourse_name(),searchCourseInfoParams.getTeacher_name(),
                searchCourseInfoParams.getCourse_types(),searchCourseInfoParams.getGeneral_types(),
                searchCourseInfoParams.getWeekdays(),searchCourseInfoParams.getBegin_secs(),
                searchCourseInfoParams.getEnd_secs(),searchCourseInfoParams.getBuilding(),
                searchCourseInfoParams.getCourse_credits(),searchCourseInfoParams.getDept_name(),
                searchCourseInfoParams.getYears(),searchCourseInfoParams.getSemester());
        for(int i=0;i<courseInfoList.size();++i)
        {
            courseInfoList.get(i).setClasses(null);
        }
        return courseInfoList;

    }

    @Override
    public CourseInfo findCourseInfoByCourseId(String course_id)
    {
        return courseRepository.findByCourse_id(course_id);
        //return courseRepository.findCouresInfoByCourseId(course_id);
    }
}
