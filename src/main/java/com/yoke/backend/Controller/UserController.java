package com.yoke.backend.Controller;

import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoByJaccount(@RequestParam("j_id") String jaccount) {
        return userService.GetUserByJaccount(jaccount);
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("u_id") String id) {
        return userService.GetUserByID(id);
    }
    */
    @RequestMapping(value = "/{jaccount}/login", method = RequestMethod.POST)
    public User loginWithJaccount(@PathVariable String jaccount) {
        User user = userService.GetUserByJaccount(jaccount);
        if (user == null) {  /** this login has unknown purpose except testing*/
            user = new User();
            user.setJaccount(jaccount);
            user.setDepartment("dept1");
            user.setSex('m');
            user.setMajor("rjgc");
            user.setName("lzw");
            user.setGrade(2017);
            userService.save(user);
            return userService.GetUserByJaccount(jaccount);
        } else return user;
    }
}
