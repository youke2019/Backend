package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
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
        User u = userService.GetUserByID("00890");
        assertEquals("Benton1950", u.getNickname());
    }

    @Test
    public void generateUserIfNoUserLike() {

        userService.generateUserIfNoUserLike(null);
        User user = new User();
        //test with null of user
        //test with null of id
        user.setMajor("RJGC");
        user.setAdmissionYear(2017);
        userService.generateUserIfNoUserLike(user);
        user.setId("01213");
        userService.generateUserIfNoUserLike(user);
        User tmpUser = userService.GetUserByID("test123456");
        assertEquals(null, tmpUser);
        user.setId("test123456");
        userService.generateUserIfNoUserLike(user);
        tmpUser = userService.GetUserByID("test123456");
        assertEquals("RJGC", tmpUser.getMajor());
        userService.removeById("test123456");
        tmpUser = userService.GetUserByID("test123456");
        assertEquals(null, tmpUser);

    }

    @Test
    public void findAll() {
        userService.findAll();
    }

    @Test
    public void save() {
        User u = userService.GetUserByID("00305");
        userService.save(u);
    }

    @Test
    public void banUser() {
        userService.banUser("00426");
        User u = userService.GetUserByID("00426");
        assertEquals(true, u.getBanned());
    }

    @Test
    public void unBanUser() {
        userService.unBanUser("00426");
        User u = userService.GetUserByID("00426");
        assertEquals(false, u.getBanned());
    }

    @Test
    public void removeById() {
        User u = userService.GetUserByID("00305");
        userService.removeById("00305");
        userService.save(u);

    }

    @Test
    public void countAll() {
        userService.countAll();
    }

    @Test
    public void findByNickname() {
        User user = userService.findByNickname("Lively1980");
        assertEquals("00126", user.getId());
    }
}