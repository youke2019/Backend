package com.yoke.backend.Controller; 

import com.yoke.backend.Entity.Course.CourseInfo;
import com.yoke.backend.Entity.Course.SearchCourseInfoParams;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/** 
* CourseController Tester. 
* 
* @author <Zhi Guo> 
* @since <pre>07/07/2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
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

    /*RestTemplate restTemplate=new RestTemplate();
    /*   合格post参数
    post参数为
    {
    "course_id":"SE101"
    }
     */
    /*
    SearchCourseInfoParams searchCourseInfoParams=new SearchCourseInfoParams();
    searchCourseInfoParams.setCourse_id("SE101");
    CourseInfo courseInfo=restTemplate.postForObject("http://localhost:8000/courses/search",searchCourseInfoParams,CourseInfo.class);
    Assert.assertEquals("电子信息与电气工程学院",courseInfo.getCourse_deptname());
    */
    /*不合格post参数
    post参数为
    {
        "courseid":"SE101"
     }
     */
    /*SearchCourseInfoParams searchCourseInfoParams1=new SearchCourseInfoParams();
    searchCourseInfoParams1.setCourse_id("SE101");
    CourseInfo courseInfo1=testRestTemplate.postForObject("/courses/search",searchCourseInfoParams1,CourseInfo.class);
    Assert.assertEquals(null,courseInfo1);*/


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
