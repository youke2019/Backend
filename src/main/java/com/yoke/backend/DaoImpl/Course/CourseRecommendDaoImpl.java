package com.yoke.backend.DaoImpl.Course;

import com.yoke.backend.Dao.Course.CourseRecommendDao;
import com.yoke.backend.Entity.Course.CourseRecommendModel;
import com.yoke.backend.repository.CourseRecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
@Repository
public class CourseRecommendDaoImpl implements CourseRecommendDao {
    @Autowired
    CourseRecommendRepository courseRecommendRepository;

    @Override
    public void save(CourseRecommendModel courseRecommendModel)
    {
        courseRecommendRepository.save(courseRecommendModel);
    }

    @Override
    public List<CourseRecommendModel> findAll()
    {
        return courseRecommendRepository.findAll();
    }
}
