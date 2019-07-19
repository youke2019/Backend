package com.yoke.backend.Controller.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Service.Course.CourseMessage.CourseQuestionService;
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
     * @api {get} /courses/questions/find
     * @apiDescription 查找课程提问
     * @apiName findQuestion
     * @apiGroup CourseMessage
     * @apiParam {String} course_id
     * @apiParam {String} user_id
     * @apiSampleRequest 47.103.30.166:8000/courses/questions/find?course_id=66974&user_id=01231
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

    /**
     * @api {post} /courses/questions/add
     * @apiDescription 添加提问
     * @apiName addQuestion
     * @apiGroup CourseMessage
     * @apiSampleRequest 47.103.30.166:8000/courses/questions/add
     * @apiSuccessExample Request-Example:
     * {
     * 	"course_id":"01190",
     * 	"user_id":"02690",
     * 	"question_content":"上课有趣吗"
     * }
     *
     * @param courseQuestion
     * @return
     */
    @RequestMapping(value = "courses/questions/add", method= RequestMethod.POST)
    @ResponseBody
    String addQuestion(@RequestBody CourseQuestion courseQuestion)
    {
        courseQuestionService.addQuestion(courseQuestion);
        return "success";
    }

    /**
     * @api {post} /courses/answers/add
     * @apiDescription 添加回答
     * @apiName addAnswer
     * @apiGroup CourseMessage
     * @apiSampleRequest 47.103.30.166:8000/courses/answers/add
     * @apiSuccessExample Post-Example:
     * {
     * 	"question_id":3,
     * 	"user_id":"01231",
     * 	"answer_content":"这是一个好问题"
     * }
     * @param courseAnswer
     * @return
     */
    @RequestMapping(value = "courses/answers/add",method = RequestMethod.POST)
    @ResponseBody
    String addAnswer(@RequestBody CourseAnswer courseAnswer)
    {
        courseQuestionService.addAnswer(courseAnswer);
        return "success";
    }

    /**
     * @api {get} /courses/questions/praise
     * @apiDescription 对问题点赞
     * @apiName praiseQuestion
     * @apiGroup CourseMessage
     * @apiParam {Integer} question_id
     * @apiParam {String} user_id
     * @apiSampleRequest 47.103.30.166:8000/courses/questions/praise?question_id=3&user_id=01231
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
     * @api {get} /courses/answers/praise
     * @apiDescription 点赞回答
     * @apiName praiseAnswers
     * @apiGroup CourseMessage
     * @apiParam {Integer} answer_id
     * @apiParam {String}  user_id
     * @apiSampleRequest 47.103.30.166:8000/courses/answers/praise?answer_id=3&user_id=01231
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
     * @api {get} /courses/questions/unpraise
     * @apiDescription 取消问题点赞
     * @apiName unpraiseQuestion
     * @apiGroup CourseMessage
     * @apiParam {Integer} question_id
     * @apiParam {String} user_id
     * @apiSampleRequest 47.103.30.166:8000/courses/questions/unpraise?question_id=3&user_id=01231
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
     * @api {get} /courses/answers/unpraise
     * @apiDescription 取消回答点赞
     * @apiName unpraiseAnswers
     * @apiGroup CourseMessage
     * @apiParam {Integer} answer_id
     * @apiParam {String } user_id
     * @apiSampleRequest 47.103.30.166:8000/courses/answers/unpraise?answer_id=3&user_id=01231
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
