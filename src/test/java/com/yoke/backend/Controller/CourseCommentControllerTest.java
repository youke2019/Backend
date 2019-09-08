package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Dao.CourseMessage.CourseCommentDao;
import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.CourseCommentReply;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.repository.CourseMessage.CourseCommentRepository;
import com.yoke.backend.repository.CourseMessage.Praise.CourseCommentPraiseRepository;
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

import javax.transaction.Transactional;
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

    @Autowired
    private CourseCommentRepository courseCommentRepository;

    @Autowired
    private CourseCommentDao courseCommentDao;

    @Autowired
    private CourseCommentPraiseRepository  courseCommentPraiseRepository;
    /**
     *
     * Method: allComment()
     *
     */
   @Test
    public void testAllComment() throws Exception {
//TODO: Test goes here...
        String response = testRestTemplate.getForObject("/courses/comments/all", String.class);
        List<CourseComment> cc = JSON.parseArray(response, CourseComment.class);
        List<CourseComment> responce = courseCommentRepository.findAll();
        Integer size = cc.size();
        Assert.assertThat(size,equalTo(responce.size()));
    }
    /**
     *
     * Method: findCommentByCourse(String course_id, String user_id)
     *
     */
    @Test
    public void testFindCommentByCourse() throws Exception {
//TODO: Test goes here...
        Map<String, String> params = new HashMap<>();
        params.put("course_id", "SE101");
        params.put("user_id","01231");
        String  result = testRestTemplate.getForObject("/courses/comments/find?course_id={course_id}&user_id={user_id}",  String.class, params);
        List<CourseComment> cc = JSON.parseArray(result , CourseComment.class);
        List<CourseComment> response = courseCommentRepository.findCommentByCourse("SE101");
        Assert.assertThat(cc.size(),equalTo(response.size()));
    }

    /**
     *
     * Method: userCommentCourse(@RequestBody CourseComment courseComment)
     *
     */
    @Test
    @Transactional
    @Rollback(true)
    public void testUserCommentCourse() throws Exception {
//TODO: Test goes here...
        CourseComment cc = new CourseComment();
        cc.setCourse_comment_content("此条为添加进入的测试条目");
        cc.setCourse_id("41899");
        cc.setUser_id("01231");
        String response = testRestTemplate.postForObject("/courses/comments/add",cc ,String.class);
        Assert.assertThat(response,equalTo("success"));
    }
    /**
     *
     * Method: withdrawCommentOfCourse(Integer comment_id)
     *
     */
    @Test
    @Transactional
    public void testWithdrawCommentOfCourse() throws Exception {
//TODO: Test goes here...
        List<CourseComment> responce = courseCommentRepository.findAll();
        Map<String,Integer> params = new HashMap<>();
        params.put("comment_id",3);
        testRestTemplate.getForObject("/courses/comments/delete?comment_id={comment_id}",  String.class, params);
        List<CourseComment> result = courseCommentDao.findCommentByCourse("88695");
        Assert.assertThat(result.size(),equalTo(0));//Report 没做关联没有处理
}

    /**
     *
     * Method: banCommentOfCourse(Integer comment_id)
     *
    */
    @Test
    @Transactional
    public void testBanCommentOfCourse() throws Exception {
//TODO: Test goes here...
        Map<String,Integer> params = new HashMap<>();
        params.put("comment_id",10);
        testRestTemplate.getForObject("/courses/comments/ban?comment_id={comment_id}",  String.class, params);
        CourseComment result = courseCommentDao.findCourseCommentById(10);
        Assert.assertThat(result.getIsbanned(),equalTo(true));
    }

   /**
     *
     * Method: unbanCommentOfCourse(Integer comment_id)
     *
     */
    @Test
    @Transactional
    public void testUnbanCommentOfCourse() throws Exception {
//TODO: Test goes here...
        Map<String,Integer> params = new HashMap<>();
        params.put("comment_id",9);
        testRestTemplate.getForObject("/courses/comments/unban?comment_id={comment_id}",  String.class, params);
        CourseComment result = courseCommentDao.findCourseCommentById(9);
        Assert.assertThat(result.getIsbanned(),equalTo(false));

    }
    /**
     *
     * Method: praiseCourseComment(String user_id, Integer course_comment_id)
     *
     */
    @Test
    @Transactional
    public void testPraiseCourseComment() throws Exception {
//TODO: Test goes here...
        Map<String,Integer> params = new HashMap<>();
        params.put("course_comment_id",4);
        params.put("user_id",79832);
        List<CourseCommentPraise> response = courseCommentPraiseRepository.findAll();
        Integer result = response.size();
        testRestTemplate.getForObject("/courses/comments/praise?course_comment_id={course_comment_id}&&user_id={user_id}",  String.class, params);
        response = courseCommentPraiseRepository.findAll();
        Assert.assertThat( response.size() - result,equalTo(0));
    }


   /**
     *
     * Method: unpraiseCourseComment(String user_id, Integer course_comment_id)
     *
     */
    @Test
    @Transactional
    public void testUnpraiseCourseComment() throws Exception {
//TODO: Test goes here...

        Map<String,Integer> params = new HashMap<>();
        params.put("course_comment_id",10);
        params.put("user_id",79832);
        CourseComment response = courseCommentDao.findCourseCommentById(10);
        Integer result = response.getCourse_comment_praise_point();
        testRestTemplate.getForObject("/courses/comments/unpraise?course_comment_id={course_comment_id}&&user_id={user_id}",  String.class, params);
        response = courseCommentDao.findCourseCommentById(10);
        Assert.assertThat(result-response.getCourse_comment_praise_point(),equalTo(0));
    }

    /**
     *
     * Method: findCourseCommentById(Integer comment_id)
     *
     */
    @Test
    @Transactional
    public void testFindCourseCommentById() throws Exception {
//TODO: Test goes here...

        Map<String,Integer> params = new HashMap<>();
        params.put("comment_id",10);
        CourseComment response = courseCommentDao.findCourseCommentById(10);
        Integer result = response.getCourse_comment_id();
        testRestTemplate.getForObject("/courses/comments/findById?comment_id={comment_id}",  String.class, params);
        response = courseCommentDao.findCourseCommentById(10);
        Assert.assertThat(result-response.getCourse_comment_id(),equalTo(0));
    }

    /**
     *
     * Method:  replyCourseComment(@RequestBody CourseCommentReply courseCommentReply)
     *
     */
    @Test
    @Transactional
    public void testReplyCourseComment() throws Exception {
//TODO: Test goes here...

        CourseCommentReply cc = new CourseCommentReply();
        cc.setCourse_comment_id(1);
        cc.setCourse_comment_reply_content("说的很中肯");
        cc.setUser_id("01231");
        String response = testRestTemplate.postForObject("/courses/comments/reply",cc ,String.class);
        Assert.assertThat(response,equalTo("success"));
    }
}