package com.yoke.backend.Controller.Course.CourseMessage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Entity.CourseMessage.CourseQuestion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* CourseEvaluateController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 23, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseEvaluateControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}
    @Autowired
    private TestRestTemplate testRestTemplate;

/**
* 
* Method: findEvaluationByCourseId(String course_id, String user_id) 
* 
*/ 
@Test
public void testFindEvaluationByCourseId() throws Exception { 
//TODO: Test goes here...
    Map<String, String> params = new HashMap<>();
    params.put("course_id", "11004");
    String  result = testRestTemplate.getForObject("/courses/evaluates/find?course_id={course_id}",  String.class, params);
    List<CourseEvaluation> cc = JSON.parseArray(result , CourseEvaluation.class);
    Assert.assertThat(cc.size(),equalTo(4));
} 

/** 
* 
* Method: addEvaluation(@RequestBody String json) 
* 
*/ 
@Test
public void testAddEvaluation() throws Exception { 
//TODO: Test goes here...
    JSONObject params = new JSONObject();
    params.put("course_id", "41899");
    params.put("user_id","79832");
    params.put("点名","根本不点");
    String  result = testRestTemplate.postForObject("/courses/evaluates/add",params,  String.class);
    Assert.assertThat(result,equalTo("success"));

} 

/** 
* 
* Method: allEvaluation() 
* 
*/ 
@Test
public void testAllEvaluation() throws Exception { 
//TODO: Test goes here...
    String response = testRestTemplate.getForObject("/courses/evaluates/all", String.class);
    List<CourseEvaluation> cc = JSON.parseArray(response, CourseEvaluation.class);
    Integer size = cc.size();
    Assert.assertThat(size,equalTo(0));
} 

/** 
* 
* Method: praiseEvaluation(Integer course_evaluate_id, String user_id) 
* 
*/ 
@Test
public void testPraiseEvaluation() throws Exception { 
//TODO: Test goes here...
    String response = testRestTemplate.getForObject("/courses/evaluates/praise?course_evaluate_id= & user_id = ", String.class);

    Assert.assertThat(response,equalTo("success"));
} 

/** 
* 
* Method: unpraiseEvaluation(Integer course_evaluate_id, String user_id) 
* 
*/ 
@Test
public void testUnpraiseEvaluation() throws Exception { 
//TODO: Test goes here...
    String response = testRestTemplate.getForObject("/courses/evaluates/unpraise?course_evaluate_id= & user_id = ", String.class);
    Assert.assertThat(response,equalTo("success"));
} 

} 
