package com.yoke.backend.Service.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseMoment;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentService {
    List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2);
    List<CourseMoment> findAll();
}
