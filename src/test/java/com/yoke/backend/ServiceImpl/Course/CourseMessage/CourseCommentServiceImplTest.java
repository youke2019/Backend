package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.yoke.backend.Entity.CourseMessage.CourseComment;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;
import com.yoke.backend.Service.Course.CourseMessage.CourseCommentService;
import com.yoke.backend.repository.CourseMessage.CourseCommentRepository;
import com.yoke.backend.repository.CourseMessage.Praise.CourseCommentPraiseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* CourseCommentServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 19, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseCommentServiceImplTest { 

    @Autowired
    CourseCommentService courseCommentService;

    @Autowired
    CourseCommentRepository courseCommentRepository;

    @Autowired
    CourseCommentPraiseRepository courseCommentPraiseRepository;


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: allComment()
    *
    */
    @Test
    public void testAllComment() throws Exception {
    //TODO: Test goes here...
        List<CourseComment> result = courseCommentService.allComment();
        Assert.assertThat(result.size(), equalTo(10));
    }

    /**
    *
    * Method: findCommentByCourse(String course_id)
    *
    */
    @Test
    public void testFindCommentByCourse() throws Exception {
    //TODO: Test goes here...
        List<CourseComment> result = courseCommentService.findCommentByCourse("41899","79832");
        Assert.assertThat(result.size() , equalTo(4));
    }

    /**
    *
    * Method: userCommentCourse(CourseComment courseComment)
    *
    */
    @Test
    public void testUserCommentCourse() throws Exception {
    //TODO: Test goes here...
        List<CourseComment> response;
        response = courseCommentRepository.findAll();
        Integer result = response.size();
        CourseComment cc = new CourseComment();
        cc.setCourse_id("59510");
        cc.setCourse_comment_content("此条为添加进入的测试条目");
        cc.setUser_id("79832");
        courseCommentService.userCommentCourse(cc);
        response = courseCommentRepository.findAll();
        Assert.assertThat(response.size()-result,equalTo(1));
    }

    /**
    *
    * Method: withdrawCommentOfCourse(Integer comment_id)
    *
    */
    @Test
    public void testWithdrawCommentOfCourse() throws Exception {
    //TODO: Test goes here...
        List<CourseComment> response;
        response = courseCommentRepository.findAll();
        Integer result = response.size();
        courseCommentService.withdrawCommentOfCourse(10);
        response = courseCommentRepository.findAll();
        Assert.assertThat(response.size()-result,equalTo(1));
    }

    /**
    *
    * Method: banCommentOfCourse(Integer comment_id)
    *
    */
    @Test
    public void testBanCommentOfCourse() throws Exception {
    //TODO: Test goes here...
        courseCommentService.banCommentOfCourse(7);
        List<CourseComment> response = courseCommentRepository.findCommentByCourse("03175");
        Assert.assertThat(response.get(0).getIsbanned(),equalTo(true));
    }

    /**
    *
    * Method: unbanCommentOfCourse(Integer comment_id)
    *
    */
    @Test
    public void testUnbanCommentOfCourse() throws Exception {
        //TODO: Test goes here...
        courseCommentService.unbanCommentOfCourse(3);
        List<CourseComment> response = courseCommentRepository.findCommentByCourse("88655");
        Assert.assertThat(response.get(0).getIsbanned(), equalTo(false));
    }
    /**
    *
    * Method: praiseCourseComment(String user_id, Integer course_comemnt_id)
    *
    */
    @Test
    public void testPraiseCourseComment() throws Exception {
    //TODO: Test goes here...
        List<CourseCommentPraise> response = courseCommentPraiseRepository.findAll();
        Integer result = response.size();
        courseCommentService.praiseCourseComment("79832",5);
    response = courseCommentPraiseRepository.findAll();
        Assert.assertThat(response.size()-result,equalTo(1));
}

    /**
    *
    * Method: unpraiseCourseComment(String user_id, Integer course_comment_id)
    *
    */
    @Test
    public void testUnpraiseCourseComment() throws Exception {
    //TODO: Test goes here...
        List<CourseCommentPraise> response = courseCommentPraiseRepository.findAll();
        Integer result = response.size();
        courseCommentService.unpraiseCourseComment("79832",7);
        response = courseCommentPraiseRepository.findAll();
        Assert.assertThat(response.size()-result,equalTo(-1));
    }
}
