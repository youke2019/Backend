package com.yoke.backend.DaoImpl.User;

import com.yoke.backend.Dao.User.FeedbackDao;
import com.yoke.backend.Entity.User.Feedback;
import com.yoke.backend.repository.User.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Repository
public class FeedbackDaoImpl implements FeedbackDao {
    @Autowired
    FeedbackRepository feedbackRepository;

    public Feedback findFeedbackById(Integer id)
    {
        return feedbackRepository.findById(id).get();
    }

    public void save(Feedback feedback)
    {
        feedbackRepository.save(feedback);
    }

    public List<Feedback> findAll()
    {
        return feedbackRepository.findAll();
    }
}
