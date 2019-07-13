package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Entity.User.User;
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
import static org.junit.Assert.*;

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
    params.put("id", "01213");
    User respUser = restTemplate.getForObject("/users/specific?id={id}", User.class, params);

        User user = new User();
        user.setId("01213");
        user.setMajor("RJGC");
        user.setBanned(true);
        user.setAdmissionYear(2017);
        String expect = JSON.toJSONString(user);
        assertEquals(expect, JSON.toJSONString(respUser));
    }

    @Test
    public void getAllUser() throws Exception {
        String response = restTemplate.getForObject("/users/all", String.class);
        List<User> users = JSON.parseArray(response, User.class);
        assertEquals(1001, users.size());
    }

    @Test
    public void banUser() {
        String id = "01213";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        restTemplate.postForObject("/users/ban?id={id}", null, String.class, params);
        User user = restTemplate.getForObject("/users/specific?id={id}", User.class, params);
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
    String id = "01213";
    Map<String, String> params = new HashMap<>();
    params.put("id", id);
    restTemplate.postForObject("/users/unban?id={id}", null, String.class, params);
    User user = restTemplate.getForObject("/users/specific?id={id}", User.class, params);
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
    assertEquals(1000, users.size());
}

/**
*
* Method: loginWithJaccount(String id)
*
*/
@Test
public void testLoginWithJaccount() throws Exception {
//TODO: Test goes here...
    User user=restTemplate.getForObject("/login?id=01213",User.class);
    assertEquals(user.getName(),null);


}


}
