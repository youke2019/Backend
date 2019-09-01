package com.yoke.backend.repository.User;

import com.yoke.backend.Entity.User.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {

}
