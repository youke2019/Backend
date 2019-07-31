package com.yoke.backend.Controller.Course;

import com.yoke.backend.Dao.Course.CourseRecommendDao;
import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.CourseMessage.CourseEvaluation;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import com.yoke.backend.Service.Course.CourseRecommendService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/** 
* CourseRecommendController Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>07/31/2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseRecommendControllerTest { 


    @Autowired
    CourseEvaluationService courseEvaluationService;

    @Autowired
    CourseRecommendService courseRecommendService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    CourseRecommendDao courseRecommendDao;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: recommendCourseInfo(String user_id, Integer size) 
* 
*/ 
@Test
public void testRecommendCourseInfo() throws Exception {
//TODO: Test goes here...
    List<CourseInfo> courseInfoList=restTemplate.getForObject("/courses/recommend/find?user_id=ID000&size=5",List.class);
    Assert.assertNotEquals(courseInfoList,null);

    List<CourseInfo> courseInfoList1=restTemplate.getForObject("/courses/recommend/find?user_id=ID000",List.class);
    Assert.assertEquals(courseInfoList1,null );
} 

/** 
* 
* Method: recommendTest() 
* 
*/ 
@Test
public void testRecommendTest() throws Exception { 
//TODO: Test goes here...
    String result=restTemplate.getForObject("/courses/recommend/data/generate",String.class);
    List<CourseEvaluation> courseEvaluationList=courseEvaluationService.allEvaluation();
    Integer size=courseEvaluationList.size();
    Integer zero=0;
    Assert.assertNotEquals(size,zero);
} 

/** 
* 
* Method: loadEvaluationData() 
* 
*/ 
@Test
public void testLoadEvaluationData() throws Exception { 
//TODO: Test goes here...
    List<CourseEvaluation> courseEvaluationList=courseEvaluationService.allEvaluation();
    Integer size=courseEvaluationList.size();
    Integer  result = restTemplate.getForObject("/courses/recommend/data/load",  Integer.class);
    Assert.assertEquals(result,size);

} 


} 
