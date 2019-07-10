package com.yoke.backend.Controller;

import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * @api {get} /users/specific
     * @apiDescription 根据Id获取用户信息
     * @apiName getUserByID
     * @apiGroup users
     * @apiVersion 1.0.0
     * @apiParam {String} id
     */
    @RequestMapping(value = "/specific", method = RequestMethod.GET)
    public User getUserByID(@RequestParam("id") String id) {

        return userService.GetUserByID(id);
    }

    /**@api {get} /users/ban
     * @apiDescription 封禁
     * @apiName banUser
     * @apiGroup users
     * @apiVersion 1.0.0
     *
     * @apiParam {String} id
     */
    @RequestMapping(value = "/ban", method = RequestMethod.POST)
    public void banUser(@RequestParam String id) {
        userService.banUser(id);
    }

    /**
     * @api {get} /users/unban
     * @apiDescription 解禁
     * @apiName unbanUser
     * @apiGroup users
     * @apiVersion 1.0.0
     * @apiParam {String} id
     */
    @RequestMapping(value = "/unban", method = RequestMethod.POST)
    public void unBanUser(@RequestParam String id) {

        userService.unBanUser(id);
    }

    /**
     * @api {get} /users/all
     * @apiDescription 获取所有用户信息
     * @apiName getAllUser
     * @apiGroup users
     * @apiVersion 1.0.0
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.findAll();
    }


    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/login")
    public User loginWithJaccount(String id) {
        User user = userService.GetUserByID(id);
        return user;
    }
}
