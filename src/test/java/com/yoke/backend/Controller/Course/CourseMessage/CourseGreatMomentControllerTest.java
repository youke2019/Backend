package com.yoke.backend.Controller.Course.CourseMessage;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Dao.CourseMessage.CourseMomentDao;
import com.yoke.backend.Dao.CourseMessage.Praise.CourseMomentPraiseDao;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;
import com.yoke.backend.Entity.CourseMessage.CourseMomentComment;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;
import com.yoke.backend.repository.CourseMessage.Praise.CourseMomentPraiseRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* CourseGreatMomentController Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 8, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseGreatMomentControllerTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
}

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private CourseMomentDao courseMomentDao;

    @Autowired
    private CourseMomentPraiseRepository courseMomentPraiseRepository;
/** 
* 
* Method: findByTimeOrder(Integer base, Integer size, String user_id) 
* 
*/ 
@Test
@Transactional
public void testFindByTimeOrder() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("base","0");
    params.put("size","1");
    params.put("user_id","01231");
    String response = testRestTemplate.getForObject("/courses/moments/find?base={base}&size={size}&user_id={user_id}",  String.class, params);
    List<CourseMoment> result = JSON.parseArray(response,CourseMoment.class);
    Assert.assertThat(result.size(),equalTo(1));
} 

/** 
* 
* Method: findAll(String user_id) 
* 
*/ 
@Test
@Transactional
public void testFindAll() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("user_id","01231");
    String response = testRestTemplate.getForObject("/courses/moments/findAll?user_id={user_id}",  String.class, params);
    List<CourseMoment> result = JSON.parseArray(response,CourseMoment.class);
    List<CourseMoment> tmp = courseMomentDao.findAll();
    Assert.assertThat(result.size(),equalTo(tmp.size()));
//TODO: Test goes here... 
} 

/** 
* 
* Method: praiseCourseMoment(Integer video_id, String user_id) 
* 
*/ 
@Test
@Transactional
public void testPraiseCourseMoment() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("video_id","19011");
    params.put("user_id","01231");
    String response = testRestTemplate.getForObject("/courses/moments/praise?video_id={video_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat( response,equalTo("success"));
} 

/** 
* 
* Method: unpraiseCourseMoment(Integer video_id, String user_id) 
* 
*/ 
@Test
@Transactional
public void testUnpraiseCourseMoment() throws Exception {
    Map<String,String> params = new HashMap<>();
    params.put("video_id","19011");
    params.put("user_id","01231");
    String response = testRestTemplate.getForObject("/courses/moments/unpraise?video_id={video_id}&&user_id={user_id}",  String.class, params);
    Assert.assertThat( response,equalTo("success"));
} 

/** 
* 
* Method: commentCourseMoment(@RequestBody CourseMomentComment courseMomentComment) 
* 
*/ 
@Test
@Transactional
public void testCommentCourseMoment() throws Exception {
    CourseMomentComment cmc = new CourseMomentComment();
    cmc.setUser_id("01231");
    cmc.setVideo_id(19011);
    cmc.setVideo_comment_content("你真棒");
    String response = testRestTemplate.postForObject("/courses/moments/comment",cmc ,String.class);
    Assert.assertThat(response,equalTo("success"));
} 

/** 
* 
* Method: postCourseMoment(@RequestBody CourseMoment courseMoment) 
* 
*/ 
@Test
@Transactional
public void testPostCourseMoment() throws Exception { 
    CourseMoment cm = new CourseMoment();
    cm.setUser_id("01231");
    cm.setVideo_type('n');
    cm.setPost_text("新学期又开始了");
    String response = testRestTemplate.postForObject("/courses/moments/post",cm ,String.class);
    Assert.assertThat(response,equalTo("success"));
} 

/** 
* 
* Method: uploadImg(@RequestParam("file")MultipartFile file, HttpServletRequest request) 
* 
*/ 
@Test
@Transactional
public void testUploadImg() throws Exception { 

} 

/** 
* 
* Method: findMomentById(Integer moment_id) 
* 
*/ 
@Test
@Transactional
public void testFindMomentById() throws Exception {
    Map<String,Integer> params = new HashMap<>();
    params.put("moment_id",19011);
    String responce = testRestTemplate.getForObject("/courses/moments/findById?moment_id={moment_id}",  String.class, params);
    CourseMoment cm = JSON.parseObject(responce,CourseMoment.class);
    Assert.assertThat(cm.getVideo_id(),equalTo(19011));
} 


} 
