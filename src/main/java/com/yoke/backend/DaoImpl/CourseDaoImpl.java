package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.CourseDao;
import com.yoke.backend.Entity.CourseInfo;
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
    public List<CourseInfo> findall()
    {
        return courseRepository.findAll();
    }

}
