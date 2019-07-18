 package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Entity.CourseMessage.CourseAnswer;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import com.yoke.backend.Entity.User.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;

 /**
* CourseQuestionController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 18, 2019</pre> 
* @version 1.0 
*/
 @RunWith(SpringRunner.class)
 @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseQuestionControllerTest {
     @Autowired
     private TestRestTemplate restTemplate;

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: findQuestionByCourse(String course_id, String user_id)
    *
    */
    @Test
    public void testFindQuestionByCourse() throws Exception {
    //TODO: Test goes here...
        Map<String, String> params = new HashMap<>();
        params.put("user_id", "84870");
        params.put("course_id","57878");
        String response = restTemplate.getForObject("/courses/questions/find?user_id={user_id}&course_id={course_id}", String.class ,params);
        List<CourseQuestion> result = JSON.parseArray(response, CourseQuestion.class);
        Assert.assertThat(result.size(), equalTo(4));

    }

/** 
* 
* Method: addQuestion(@RequestBody CourseQuestion courseQuestion) 
* 
*/ 
@Test
public void testAddQuestion() throws Exception { 
//TODO: Test goes here...
    CourseQuestion courseQuestion = new CourseQuestion();
    courseQuestion.setCourse_id("66974");
    courseQuestion.setUser_id("84870");
    courseQuestion.setQuestion_content("测试用数据内容");
    String response = restTemplate.postForObject("/courses/questions/add",courseQuestion ,String.class);
    Assert.assertThat(response,equalTo("success"));
} 

/** 
* 
* Method: addAnswer(@RequestBody CourseAnswer courseAnswer) 
* 
*/ 
@Test
public void testAddAnswer() throws Exception { 
//TODO: Test goes here...
    CourseAnswer courseAnswer = new CourseAnswer();
    courseAnswer.setQuestion_id(4);
    courseAnswer.setUser_id("84870");
    courseAnswer.setAnswer_content("这是个测试数据");

    String response = restTemplate.postForObject("/courses/answers/add",courseAnswer,String.class);
    Assert.assertThat(response,equalTo("success"));
}

/** 
* 
* Method: praiseQuestion(Integer question_id, String user_id) 
* 
*/ 
@Test
public void testPraiseQuestion() throws Exception { 
//TODO: Test goes here...
    Map<String,String> params = new HashMap<>();
    params.put("question_id","10");
    params.put("user_id","84870");
    String  result = restTemplate.getForObject("/courses/questions/praise?question_id={question_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
} 

/** 
* 
* Method: praiseAnswer(Integer answer_id, String user_id) 
* 
*/ 
@Test
public void testPraiseAnswer() throws Exception { 
//TODO: Test goes here...
    Map<String,String> params = new HashMap<>();
    params.put("answer_id","4");
    params.put("user_id","84870");
    String  result = restTemplate.getForObject("/courses/answers/praise?answer_id={answer_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
} 

/** 
* 
* Method: unpraiseQuestion(Integer question_id, String user_id) 
* 
*/ 
@Test
public void testUnpraiseQuestion() throws Exception { 
//TODO: Test goes here...
    Map<String,String> params = new HashMap<>();
    params.put("question_id","10");
    params.put("user_id","84870");
    String  result = restTemplate.getForObject("/courses/questions/unpraise?question_id={question_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
} 

/** 
* 
* Method: unpraiseAnswer(Integer answer_id, String user_id) 
* 
*/ 
@Test
public void testUnpraiseAnswer() throws Exception { 
//TODO: Test goes here...
    Map<String,String> params = new HashMap<>();
    params.put("answer_id","10");
    params.put("user_id","84870");
    String  result = restTemplate.getForObject("/courses/answers/unpraise?answer_id={answer_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
}
 }



