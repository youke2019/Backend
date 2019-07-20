package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Entity.CourseMessage.CourseMomentComment;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentService {
    List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2);
    List<CourseMoment> findAll(String user_id);
    void commentCourseMoment(CourseMomentComment courseMomentComment);
    void praiseCourseMoment(Integer video_id,String user_id);
    void unpraiseCourseMoment(Integer video_id,String user_id);
    void postCourseMoment(CourseMoment courseMoment);
}
