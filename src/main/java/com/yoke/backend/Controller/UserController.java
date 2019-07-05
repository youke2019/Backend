package com.yoke.backend.Controller;

import com.yoke.backend.Entity.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /* @RequestMapping(value= "/",method = RequestMethod.GET)
    public User getUserInfoByJaccount(@RequestParam("j_id") String id){
        return userService.GetUserByJaccountID(id);
    }*/
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("u_id") String id) {
        return userService.GetUserByID(id);
    }


    @RequestMapping(value = "/{jaccount}/login", method = RequestMethod.POST)
    public User loginWithJaccount(@PathVariable String jaccount) {
        User user = userService.GetUserByJaccountID(jaccount);
        if (user == null) {
            user = new User();
            user.setJaccount(jaccount);
            user.setDepartment("dept1");
            user.setSex('m');
            user.setMajor("rjgc");
            user.setName("lzw");
            user.setGrade(2017);
            user.setId(jaccount + "lzw");
            userService.save(user);
            return userService.GetUserByJaccountID(jaccount);
        } else return user;
    }
}
