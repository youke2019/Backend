package com.yoke.backend.DaoImpl.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseMomentDao;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.repository.CourseMessage.CourseMomentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Repository
public class CourseMomentDaoImpl implements CourseMomentDao {
    @Autowired
    CourseMomentRepository courseMomentRepository;

    @Override
    public List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2)
    {
        return courseMomentRepository.findByTimeOrder(serialNumber1, serialNumber2);
    }

    @Override
    public List<CourseMoment> findAll()
    {
        return courseMomentRepository.findCourseMoment();
    }

    @Override
    public void save(CourseMoment courseMoment)
    {
        courseMomentRepository.save(courseMoment);
    }

    @Override
    public CourseMoment findById(Integer id)
    {
        return courseMomentRepository.findById(id).get();
    }
}
