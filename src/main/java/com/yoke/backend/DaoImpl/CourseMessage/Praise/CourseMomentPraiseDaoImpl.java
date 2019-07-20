package com.yoke.backend.DaoImpl.CourseMessage.Praise;

import com.yoke.backend.Dao.CourseMessage.Praise.CourseMomentPraiseDao;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;
import com.yoke.backend.repository.CourseMessage.CourseMomentRepository;
import com.yoke.backend.repository.CourseMessage.Praise.CourseMomentPraiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Repository
public class CourseMomentPraiseDaoImpl implements CourseMomentPraiseDao {
    @Autowired
    CourseMomentPraiseRepository courseMomentPraiseRepository;

    @Override
    public void save(CourseMomentPraise courseMomentPraise)
    {
        courseMomentPraiseRepository.save(courseMomentPraise);
    }

    @Override
    public void delete(Integer video_id,String user_id)
    {
        courseMomentPraiseRepository.delete(video_id,user_id);
    }
}
