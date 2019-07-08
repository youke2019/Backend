package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSON;
import com.yoke.backend.Entity.User.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setup() {
    }

    @Test
    public void getUserByID() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("id", "01213");
        User respUser = restTemplate.getForObject("/users/specific?id={id}", User.class, params);

        User user = new User();
        user.setId("01213");
        user.setName("Lakita2022");
        user.setDepartment("Facilities");
        user.setMajor("6ND0K0TLK7195F2");
        user.setAdmissionYear(2017);
        user.setSex('M');
        user.setNickname("Cherryl77");
        user.setBanned(true);

        String expect = JSON.toJSONString(user);
        assertEquals(expect, JSON.toJSONString(respUser));
    }

    @Test
    public void getAllUser() throws Exception {
        String response = restTemplate.getForObject("/users/all", String.class);
        List<User> users = JSON.parseArray(response, User.class);
        assertEquals(1000, users.size());
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

    @Test
    public void unBanUser() {
        String id = "01213";
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        restTemplate.postForObject("/users/unban?id={id}", null, String.class, params);
        User user = restTemplate.getForObject("/users/specific?id={id}", User.class, params);
        assertEquals(false, user.getBanned());
    }
}