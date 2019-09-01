package com.yoke.backend.ServiceImpl.User;

import com.yoke.backend.Dao.User.FeedbackDao;
import com.yoke.backend.Entity.User.Feedback;
import com.yoke.backend.Service.User.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackDao feedbackDao;

    public void save(Feedback feedback)
    {
        feedbackDao.save(feedback);
    }

    public List<Feedback> findAll()
    {
        return feedbackDao.findAll();
    }
}
