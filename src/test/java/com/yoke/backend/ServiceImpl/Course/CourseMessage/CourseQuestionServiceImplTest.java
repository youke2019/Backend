package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestionPraise;
import com.yoke.backend.Service.Course.CourseMessage.CourseQuestionService;
import com.yoke.backend.repository.CourseMessage.CourseAnswerRepository;
import com.yoke.backend.repository.CourseMessage.CourseQuestionRepository;
import com.yoke.backend.repository.CourseMessage.Praise.CourseAnswerPraiseRepositroy;
import com.yoke.backend.repository.CourseMessage.Praise.CourseQuestionPraiseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* CourseQuestionServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 19, 2019</pre> 
* @version 1.0 
*/


@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseQuestionServiceImplTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    @Autowired
    private CourseQuestionService courseQuestionService;

    @Autowired
    private CourseQuestionRepository courseQuestionRepository;

    @Autowired
    private CourseAnswerRepository courseAnswerRepository;

    @Autowired
    private CourseQuestionPraiseRepository courseQuestionPraiseRepository;

    @Autowired
    private CourseAnswerPraiseRepositroy courseAnswerPraiseRepositroy;

    /**
    *
    * Method: findQuestionByCourse(String course_id, String user_id)
    *
    */
    @Test
    public void testFindQuestionByCourse() throws Exception {
    //TODO: Test goes here...
        List<CourseQuestion> responce = courseQuestionService.findQuestionByCourse("57878","46420");
        List<CourseQuestion> result = courseQuestionRepository.findQuestionByCourse("57878");
        Assert.assertEquals(responce.size(),result.size());

        responce = courseQuestionService.findQuestionByCourse("11111","46420");
        result = courseQuestionRepository.findQuestionByCourse("11111");
        Assert.assertEquals(responce.size(),result.size());
    }

    /**
    *
    * Method: addQuestion(CourseQuestion courseQuestion)
    *
    */
    @Test
    public void testAddQuestion() throws Exception {
    //TODO: Test goes here...
        CourseQuestion courseQuestion = new CourseQuestion();
        courseQuestion.setCourse_id("66974");
        courseQuestion.setUser_id("84870");
        courseQuestion.setQuestion_content("测试用数据内容");

        List<CourseQuestion> response = courseQuestionRepository.findAll();
        Integer result = response.size();
        courseQuestionService.addQuestion(courseQuestion);
        response = courseQuestionRepository.findAll();
        Assert.assertThat(response.size()-result,equalTo(1));
    }

    /**
    *
    * Method: addAnswer(CourseAnswer courseAnswer)
    *
    */
    @Test
    public void testAddAnswer() throws Exception {
    //TODO: Test goes here...
        CourseAnswer courseAnswer = new CourseAnswer();
        courseAnswer.setQuestion_id(4);
        courseAnswer.setUser_id("84870");
        courseAnswer.setAnswer_content("这是个测试数据");

        List<CourseAnswer> responce = courseAnswerRepository.findAll();
        Integer result = responce.size();
        courseQuestionService.addAnswer(courseAnswer);
        responce = courseAnswerRepository.findAll();
        Assert.assertEquals(responce.size()-result,1);
    }

    /**
    *
    * Method: praiseQuestion(Integer question_id, String user_id)
    *
    */
    @Test
    public void testPraiseQuestion() throws Exception {
    //TODO: Test goes here...
        List<CourseQuestionPraise> response = courseQuestionPraiseRepository.findAll();
        Integer result = response.size();
        courseQuestionService.praiseQuestion(4,"79832");
        response = courseQuestionPraiseRepository.findAll();
        Assert.assertEquals(response.size()-result,1);
    }

    /**
    *
    * Method: praiseAnswer(Integer answer_id, String user_id)
    *
    */
    @Test
    public void testPraiseAnswer() throws Exception {
    //TODO: Test goes here...
        List<CourseAnswerPraise> response = courseAnswerPraiseRepositroy.findAll();
        Integer result = response.size();
        courseQuestionService.praiseAnswer(1,"79832");
        response = courseAnswerPraiseRepositroy.findAll();
        Assert.assertEquals(response.size()-result,1);
    }

    /**
    *
    * Method: unpraiseQuestion(Integer question_id, String user_id)
    *
    */
    @Test
    public void testUnpraiseQuestion() throws Exception {
    //TODO: Test goes here...
        List<CourseQuestionPraise> response = courseQuestionPraiseRepository.findAll();
        Integer result = response.size();
        courseQuestionService.unpraiseQuestion(2,"62060");
        response = courseQuestionPraiseRepository.findAll();
        Assert.assertEquals(-response.size()+result,2);
    }

    /**
    *
    * Method: unpraiseAnswer(Integer answer_id, String user_id)
    *
    */
    @Test
    public void testUnpraiseAnswer() throws Exception {
    //TODO: Test goes here...
        List<CourseAnswerPraise> response = courseAnswerPraiseRepositroy.findAll();
        Integer result = response.size();
        courseQuestionService.unpraiseAnswer(2,"76074");
        response = courseAnswerPraiseRepositroy.findAll();
        Assert.assertEquals(-response.size()+result,1);
    }


} 
