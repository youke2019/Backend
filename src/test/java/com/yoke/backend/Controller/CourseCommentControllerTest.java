package com.yoke.backend.Controller;


import com.alibaba.fastjson.JSON;
import com.yoke.backend.Entity.CourseMessage.CourseComment;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;

/** 
* CourseCommentController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 15, 2019</pre>
* @version 1.0 
*/


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseCommentControllerTest { 

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
* Method: allComment() 
* 
*/ 
@Test
public void testAllComment() throws Exception {
    ParameterizedTypeReference<List<CourseComment>> type = new ParameterizedTypeReference<List<CourseComment>>() {};
    ResponseEntity<List<CourseComment>> result = testRestTemplate.exchange("/courses/comments/all", HttpMethod.GET, null, type);
    Assert.assertThat(result.getBody().get(0).getCourse_comment_id(), equalTo(1));

    String response = testRestTemplate.getForObject("/courses/comments/all", String.class);
    List<CourseComment> cc = JSON.parseArray(response, CourseComment.class);

    Integer size = cc.size();
    Assert.assertThat(size,equalTo(12));
}
    @Test
    public void testAllComment() throws Exception {
//TODO: Test goes here...
        String response = testRestTemplate.getForObject("/courses/comments/all", String.class);
        List<CourseComment> cc = JSON.parseArray(response, CourseComment.class);

        Integer size = cc.size();
        Assert.assertThat(size,equalTo(12));
    }
    /**
* 
* Method: findCommentByCourse(String course_id) 
* 
*/ 
@Test
public void testFindCommentByCourse() throws Exception { 
//TODO: Test goes here...
    Map<String, String> params = new HashMap<>();
    params.put("course_id", "2");
    ParameterizedTypeReference<List<CourseComment>> type = new ParameterizedTypeReference<List<CourseComment>>() {};
    String  result = testRestTemplate.getForObject("/courses/comments/sortbycourseid?course_id={course_id}",  String.class, params);
    List<CourseComment> cc = JSON.parseArray(result , CourseComment.class);
    Assert.assertThat(cc.size(),equalTo(5));
} 

/** 
* 
* Method: userCommentCourse(@RequestBody CourseComment courseComment) 
* 
*/

@Test
public void testUserCommentCourse() throws Exception { 
//TODO: Test goes here...
    CourseComment cc = new CourseComment();
    cc.setCourse_id("1");
    cc.setCourse_comment_content("此条为添加进入的测试条目");
    cc.setUser_id(0);
    String response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
    Assert.assertThat(response,not("success"));

    cc.setCourse_id("41899");
    response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
    Assert.assertThat(response,not("success"));

    cc.setUser_id(01231);
    response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
    Assert.assertThat(response,not("success"));
    //不能以0 开头

    cc.setUser_id(79832);
    response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
    Assert.assertThat(response,equalTo("success"));
}
    @Test
    @Transactional
    @Rollback(true)
    public void testUserCommentCourse1() throws Exception {
//TODO: Test goes here...
        CourseComment cc = new CourseComment();
        cc.setCourse_id("41899");
        cc.setCourse_comment_content("此条为添加进入的测试条目");
        cc.setUser_id(0);
        String response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
        Assert.assertThat(response,not("success"));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void testUserCommentCourse2() throws Exception {
//TODO: Test goes here...
        CourseComment cc = new CourseComment();
        cc.setCourse_id("41899");
        cc.setCourse_comment_content("此条为添加进入的测试条目");
        cc.setUser_id(01231);
        String response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
        Assert.assertThat(response,not("success"));
    }
    @Test
    @Transactional
    @Rollback(true)
    public void testUserCommentCourse3() throws Exception {
//TODO: Test goes here...
        CourseComment cc = new CourseComment();
        cc.setCourse_id("41899");
        cc.setCourse_comment_content("此条为添加进入的测试条目");
        cc.setUser_id(79832);
        String response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
        Assert.assertThat(response,equalTo("success"));
    }
    /**
* 
* Method: withdrawCommentOfCourse(Integer comment_id) 
* 
*/ 
@Test
public void testWithdrawCommentOfCourse() throws Exception { 
//TODO: Test goes here...
    Map<String,Integer> params = new HashMap<>();
    params.put("comment_id",2);
    String  result = testRestTemplate.getForObject("/courses/comments/withdraw?comment_id={comment_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
} 

/** 
* 
* Method: banCommentOfCourse(Integer comment_id) 
* 
*/ 
@Test
public void testBanCommentOfCourse() throws Exception { 
//TODO: Test goes here...
    Map<String,Integer> params = new HashMap<>();
    params.put("comment_id",1);
    String  result = testRestTemplate.getForObject("/courses/comments/ban?comment_id={comment_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
} 

/** 
* 
* Method: unbanCommentOfCourse(Integer comment_id) 
* 
*/

@Test
public void testUnbanCommentOfCourse() throws Exception { 
//TODO: Test goes here...
    Map<String,Integer> params = new HashMap<>();
    params.put("comment_id",1);
    String  result = testRestTemplate.getForObject("/courses/comments/unban?comment_id={comment_id}",  String.class, params);
    Assert.assertThat(result,equalTo("success"));
}


} 
