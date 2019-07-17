package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Service.Course.CourseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@RestController
@RequestMapping(value = "/courses/questions")
public class CourseQuestionController {
    @Autowired
    CourseQuestionService courseQuestionService;

    /**
     *
     * @param course_id
     * @param user_id
     * @return
     */
    @GetMapping(value = "find")
    List<CourseQuestion> findQuestionByCourse(String course_id,String user_id)
    {
        return courseQuestionService.findQuestionByCourse(course_id, user_id);
    }
}
