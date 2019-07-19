package com.yoke.backend.Dao.CourseMessage.Praise;

import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
public interface CourseMomentPraiseDao {
    void save(CourseMomentPraise courseMomentPraise);
    void delete(Integer video_id,String user_id);
}
