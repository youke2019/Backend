package com.yoke.backend.ServiceImpl.Course.CourseMessage;

import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Service.Course.CourseMessage.CourseEvaluationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/** 
* CourseEvaluationServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>七月 19, 2019</pre> 
* @version 1.0 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseEvaluationServiceImplTest { 
    @Autowired
    CourseEvaluationService courseEvaluationService;


    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: allEvaluation()
    *
    */
    @Test
    public void testAllEvaluation() throws Exception {
    //TODO: Test goes here...
        List<Map> response = courseEvaluationService.allEvaluation();
        Assert.assertEquals(response.size(),8);
    }

    /**
    *
    * Method: findEvaluationByCourseId(String course_id)
    *
    */
    @Test
    public void testFindEvaluationByCourseId() throws Exception {
    //TODO: Test goes here...
        List<Map> response = courseEvaluationService.findEvaluationByCourseId("41899");
        Assert.assertEquals(response.size(),4);
    }

    /**
    *
    * Method: addCourseEvaluation(String json)
    *
    */
    @Test
    public void testAddCourseEvaluation() throws Exception {
    //TODO: Test goes here...
        JSONObject params = new JSONObject();
        params.put("course_id", "11004");
        params.put("user_id","79832");
        params.put("点名","根本不点");
        courseEvaluationService.addCourseEvaluation(params.toJSONString());
        List<Map> response = courseEvaluationService.findEvaluationByCourseId("11004");
        Assert.assertEquals(response.size(),5);
    }


} 
