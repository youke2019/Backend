package com.yoke.backend.Controller; 

import com.yoke.backend.Entity.Course.CourseInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/** 
* CourseController Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>07/07/2019</pre> 
* @version 1.0 
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CourseControllerTest { 
    @Autowired
    private TestRestTemplate testRestTemplate;

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: UpdateCourseInfoFromJWC(String url, String cookies) 
* 
*/ 
@Test
public void testUpdateCourseInfoFromJWC() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: SearchCourseInfo(@RequestBody SearchCourseInfoParams searchCourseInfoParams) 
* 
*/ 
@Test
public void testSearchCourseInfo() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: SpecificCourseInfo(String course_id) 
* 
*/ 
@Test
public void testSpecificCourseInfo() throws Exception { 
//TODO: Test goes here...
    CourseInfo courseInfo = testRestTemplate.getForObject("/courses/specific?course_id=SE101",CourseInfo.class);
    Assert.assertEquals(5.0,courseInfo.getCourse_credits(),0.1);
    CourseInfo courseInfo1=testRestTemplate.getForObject("/courses/specific?course_id=XP401",CourseInfo.class);
    Assert.assertEquals("生产实习（软件工程）",courseInfo1.getCourse_name());
} 


} 
