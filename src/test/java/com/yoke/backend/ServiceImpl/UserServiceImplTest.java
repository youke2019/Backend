package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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
    public void generateUserIfNoUserLike() {
        User user1 = new User();

    }
}