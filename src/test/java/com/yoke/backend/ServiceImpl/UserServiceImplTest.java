package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getUserByID() {

    }
    @Test
    public void save(){
        User user1=new User();
        user1.setId("00126");
        userService.save(user1);
    }

    @Test
    public void generateUserIfNoUserLike() {
        User user1=new User();
        user1.setId("00126");
        userService.generateUserIfNoUserLike(user1);

    }
}