package com.yoke.backend.Service.User;

import com.yoke.backend.Entity.User.Feedback;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface FeedbackService {
    void save(Feedback feedback);
    List<Feedback> findAll();
}
