package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseMomentDao;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Service.Course.CourseMessage.CourseMomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Service
public class CourseMomentServiceImpl implements CourseMomentService {
    @Autowired
    CourseMomentDao courseMomentDao;

    @Override
    public List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNubmer2)
    {
        return courseMomentDao.findByTimeOrder(serialNumber1, serialNubmer2);
    }

    @Override
    public List<CourseMoment> findAll()
    {
        return courseMomentDao.findAll();
    }
}
