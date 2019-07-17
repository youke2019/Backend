package com.yoke.backend.Controller;

import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Service.Course.CourseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@RestController
public class CourseQuestionController {
    @Autowired
    CourseQuestionService courseQuestionService;



    /**
     *@api {get} /course/questions/find
     * @apiName findQuestion
     * @apiGroup CourseMessage
     * @apiPram  通过课程ID查找提问
     * @apiPram  example: http://localhost:8080/courses/questions/find?course_id=83374&user_id=02690
     * @apiSuccessExample Request-Example:
     * [
     *     {
     *         "question_id": 2,
     *         "user_id": "02690",
     *         "course_id": "83374",
     *         "question_content": "N7F06OYB391SU39BJJF",
     *         "question_time": "K2NX15",
     *         "question_isbanned": false,
     *         "question_praise_point": -1118681120,
     *         "courseAnswerList": [
     *             {
     *                 "answer_id": 3,
     *                 "question_id": 2,
     *                 "user_id": "66089",
     *                 "answer_content": "G7C324I5J5G6U4OBNPYGC502XW326NYJOQZE8V0GDZDC0PE7VM6H86O3042C1U44RI913S0PP",
     *                 "answer_time": "J55",
     *                 "answer_isbanned": true,
     *                 "answer_praise_point": -769,
     *                 "current_user_praise": false,
     *                 "courseAnswerPraiseList": []
     *             },
     *             {
     *                 "answer_id": 5,
     *                 "question_id": 2,
     *                 "user_id": "66089",
     *                 "answer_content": "1830S56S72VU1Z27Y3O71DWP4I3E7OEQ629J29KFMBK80V1R7NSNJ67T5Y8ZBPM3",
     *                 "answer_time": "51K",
     *                 "answer_isbanned": false,
     *                 "answer_praise_point": -2088129467,
     *                 "current_user_praise": false,
     *                 "courseAnswerPraiseList": [
     *                     {
     *                         "answer_praise_id": 9,
     *                         "user_id": "85373",
     *                         "answer_id": 5
     *                     }
     *                 ]
     *             }
     *         ],
     *         "courseQuestionPraiseList": [],
     *         "current_user_praise": false
     *     }
     * ]
     *
     * @param course_id
     * @param user_id
     * @return
     */
    @GetMapping(value = "courses/questions/find")
    List<CourseQuestion> findQuestionByCourse(String course_id,String user_id)
    {
        return courseQuestionService.findQuestionByCourse(course_id, user_id);
    }

    @RequestMapping(value = "courses/questions/add", method= RequestMethod.POST)
    @ResponseBody
    String addQuestion(@RequestBody CourseQuestion courseQuestion)
    {
        courseQuestionService.addQuestion(courseQuestion);
        return "success";
    }

    @RequestMapping(value = "courses/answers/add",method = RequestMethod.POST)
    @ResponseBody
    String addAnswer(@RequestBody CourseAnswer courseAnswer)
    {
        courseQuestionService.addAnswer(courseAnswer);
        return "success";
    }

    /**
     *
     * @param question_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "courses/questions/praise")
    String praiseQuestion(Integer question_id,String user_id)
    {
        courseQuestionService.praiseQuestion(question_id, user_id);
        return "success";
    }

    /**
     *
     * @param answer_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "courses/answers/praise")
    String praiseAnswer(Integer answer_id,String user_id)
    {
        courseQuestionService.praiseAnswer(answer_id, user_id);
        return "success";
    }

    /**
     *
     * @param question_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "courses/questions/unpraise")
    String unpraiseQuestion(Integer question_id,String user_id)
    {
        courseQuestionService.unpraiseQuestion(question_id, user_id);
        return "success";
    }

    /**
     *
     * @param answer_id
     * @param user_id
     * @return
     */
    @RequestMapping(value = "courses/answers/unpraise")
    String unpraiseAnswer(Integer answer_id,String user_id)
    {
        courseQuestionService.unpraiseAnswer(answer_id, user_id);
        return "success";
    }




}
