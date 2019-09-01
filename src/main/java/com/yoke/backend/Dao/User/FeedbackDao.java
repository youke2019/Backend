package com.yoke.backend.Dao.User;

import com.yoke.backend.Entity.User.Feedback;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface FeedbackDao {
    Feedback findFeedbackById(Integer id);
    void save(Feedback feedback);
    List<Feedback> findAll();
}
