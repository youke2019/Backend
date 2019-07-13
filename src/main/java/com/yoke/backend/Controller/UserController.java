package com.yoke.backend.Controller;

import com.alibaba.fastjson.JSONObject;
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
     *@apiHeaderExample {json} Response-Example:
     * {
     *         "ID":"userID-string",
     *         "name":"刘政委",
     *         "major":"软件工程",
     *         "admissionYear":2017,
     *         "sex": 'M' or 'F',
     *         "department": "电子信息与电气工程学院",
     *         "nickname": "昵称",
     *         "banned": True or False, //封禁
     * }
     * */
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
     *@apiHeaderExample {json} Response-Example:
     * [
     *     {
     *         "ID":"userID-string",
     *         "name":"刘政委",
     *         "major":"软件工程",
     *         "admissionYear":2017,
     *         "sex": 'M' or 'F',
     *         "department": "电子信息与电气工程学院",
     *         "nickname": "昵称",
     *         "banned": True or False, //封禁
     *     }
     * ]
     * */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.findAll();
    }

    /*
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public User getUserInfoById(@RequestParam("u_id") String id) {
        return userService.GetUserByID(id);
    }
    */


    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUserInfo(@RequestBody User user) {
        JSONObject resp = new JSONObject();
        User userByNickname = userService.findByNickname(user.getNickname());
        if (userByNickname != null && userByNickname.getId() != user.getId()) {
            System.out.println("Duplicate Nickname");
            resp.put("success", false);
            resp.put("error_msg", "Duplicate Nickname");
            return resp.toJSONString();
        }
        userService.save(user);
        System.out.println("update success");
        resp.put("success", true);
        return resp.toJSONString();
    }
}
