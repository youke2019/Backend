package com.yoke.backend.Controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;

/** 
* TimeController Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 8, 2019</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TimeControllerTest { 

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
* Method: getWeek() 
* 
*/ 
@Test
public void testGetWeek() throws Exception { 
    String response = testRestTemplate.getForObject("/time/week",String.class);
    boolean result=response.matches("[0-9]+");
    Assert.assertThat(result,equalTo(true));
} 

} 
