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

    /**
     *
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoByJaccount(@RequestParam("id") String jaccount) {
        return userService.GetUserByID(jaccount);
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("u_id") String id) {
        return userService.GetUserByID(id);
    }
    */
    @RequestMapping(value = "/{id}/login", method = RequestMethod.POST)
    public User loginWithJaccount(@PathVariable String id) {
        User user = userService.GetUserByID(id);
        if (user == null) {  /** this login has unknown purpose except testing*/
            user = new User();
            user.setID(id);
            user.setDepartment("dept1");
            user.setSex('m');
            user.setMajor("rjgc");
            user.setName("lzw");
            user.setAdmissionYear(2017);
            userService.save(user);
            return userService.GetUserByID(id);
        } else return user;
    }
}
