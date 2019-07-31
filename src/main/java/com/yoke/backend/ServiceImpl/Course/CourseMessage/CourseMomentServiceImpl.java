package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Dao.CourseMessage.CourseMomentCommentDao;
import com.yoke.backend.Dao.CourseMessage.CourseMomentDao;
import com.yoke.backend.Dao.CourseMessage.Praise.CourseMomentPraiseDao;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Entity.CourseMessage.CourseMomentComment;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;
import com.yoke.backend.Service.Course.CourseMessage.CourseMomentService;
import com.yoke.backend.Service.SensitiveFilter.FilterService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    CourseMomentPraiseDao courseMomentPraiseDao;

    @Autowired
    CourseMomentCommentDao courseMomentCommentDao;

    @Autowired
    FilterService filterService;

    @Override
    public List<CourseMoment> findByTimeOrder(Integer serialNumber1,Integer serialNumber2,String user_id)
    {
        List<CourseMoment> courseMomentList=courseMomentDao.findByTimeOrder(serialNumber1, serialNumber2);
        for(CourseMoment courseMoment:courseMomentList) {
            for (CourseMomentPraise courseMomentPraise : courseMoment.getCourseMomentPraiseList()) {
                if (courseMomentPraise.getUser_id() != null && courseMomentPraise.getUser_id().equals(user_id)) {
                    courseMoment.setCurrent_user_praise(true);
                }
            }
            courseMoment.setCourseMomentPraiseList(null);
        }
        return courseMomentList;
    }

    @Override
    public List<CourseMoment> findAll(String user_id)
    {
        List<CourseMoment> courseMomentList=courseMomentDao.findAll();
        for(CourseMoment courseMoment:courseMomentList)
        {
            for(CourseMomentPraise courseMomentPraise:courseMoment.getCourseMomentPraiseList())
            {
                if(courseMomentPraise.getUser_id().equals(user_id))
                {
                    courseMoment.setCurrent_user_praise(true);
                }
            }
        }
        return courseMomentList;
    }

    @Override
    public void commentCourseMoment(CourseMomentComment courseMomentComment)
    {
        courseMomentComment.setVideo_comment_content(filterService.filter(courseMomentComment.getVideo_comment_content()));
        courseMomentCommentDao.save(courseMomentComment);
    }

    @Override
    public void praiseCourseMoment(Integer video_id,String user_id)
    {
        CourseMomentPraise courseMomentPraise=new CourseMomentPraise(video_id,user_id);
        courseMomentPraiseDao.save(courseMomentPraise);
    }

    @Override
    public void unpraiseCourseMoment(Integer video_id,String user_id)
    {
        courseMomentPraiseDao.delete(video_id, user_id);
    }

    @Override
    public void postCourseMoment(CourseMoment courseMoment)
    {
        courseMoment.setPost_text(filterService.filter(courseMoment.getPost_text()));
        courseMomentDao.save(courseMoment);
    }

}
