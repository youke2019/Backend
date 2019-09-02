package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Entity.User.Feedback;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.repository.User.FeedbackRepository;
import com.yoke.backend.repository.User.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
* UserController Tester.
*
* @author <Zhi Guo>
* @since <pre>07/10/2019</pre>
* @version 1.0
*/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
@Autowired
private TestRestTemplate restTemplate;
@Autowired
private UserRepository userRepository;

@Autowired
private FeedbackRepository feedbackRepository;
@Before
public void before() throws Exception {
}

@After
public void after() throws Exception {
}

/**
*
* Method: getUserByID(@RequestParam("id") String id)
*
*/
@Test
public void testGetUserByID() throws Exception {
    Map<String, String> params = new HashMap<>();
    params.put("id", "01231");
    User respUser = restTemplate.getForObject("/users/specific?id={id}", User.class, params);

        User user = new User();
        user.setId("01231");
        user.setMajor("1LA66KCA6E");
        user.setBanned(true);
        user.setAdmissionYear(-2);
        user.setSex('M');
        user.setName("Wilhelm466");
        user.setNickname("Diego46");
        user.setDepartment("Information Technology");
        String expect = JSON.toJSONString(user);
        assertEquals(expect, JSON.toJSONString(respUser));
    }

    @Test
    public void banUser() {
        Map<String, String> params = new HashMap<>();
        params.put("id", "01231");
        restTemplate.postForObject("/users/ban?id={id}", null, String.class, params);
        User user = userRepository.findUserById("01231");
        assertEquals(true, user.getBanned());
    }

/**
*
* Method: unBanUser(@RequestParam String id)
*
*/
@Test
public void testUnBanUser() throws Exception {
//TODO: Test goes here...
    String id = "01231";
    Map<String, String> params = new HashMap<>();
    params.put("id", id);
    restTemplate.postForObject("/users/unban?id={id}", null, String.class, params);
    User user = userRepository.findUserById("01231");
    assertEquals(false, user.getBanned());
}

/**
*
* Method: getAllUser()
*
*/
@Test
public void testGetAllUser() throws Exception {
//TODO: Test goes here...
    String response = restTemplate.getForObject("/users/all", String.class);
    List<User> users = JSON.parseArray(response, User.class);
    assertEquals(10, users.size());
}

/**
*
* Method: loginWithJaccount(String id)
*
*/
@Test
public void testLoginWithJaccount() throws Exception {
//TODO: Test goes here...
    User user=restTemplate.getForObject("/login?id=01231",User.class);
    assertEquals(user.getName(),null);


}

@Test
public void testUploadFeedback(){
    JSONObject requeset=new JSONObject();
    requeset.put("user_id","ID001");
    String response=restTemplate.postForObject("users/feedback/add",requeset,String.class);
    JSONObject response_json=JSONObject.parseObject(response);
    Assert.assertEquals(false,response_json.get("success"));

    requeset.put("content","按我说的去做");
    response=restTemplate.postForObject("users/feedback/add",requeset,String.class);
    response_json=JSONObject.parseObject(response);
    Assert.assertEquals(true,response_json.get("success"));
}

@Test
public void testAllFeedback()
{
    String response=restTemplate.getForObject("users/feedback/all",String.class);
    List<Feedback> feedbacks=JSON.parseArray(response,Feedback.class);
    Assert.assertEquals(feedbackRepository.findAll().size(),feedbacks.size());
}
}
