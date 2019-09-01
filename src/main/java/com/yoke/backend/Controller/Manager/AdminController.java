package com.yoke.backend.Controller.Manager;

import com.yoke.backend.Entity.Manager.SystemMessage;
import com.yoke.backend.Service.Manager.AdminService;
import com.yoke.backend.Service.Manager.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@RestController
@RequestMapping(value = "/manager")
public class AdminController {

    @Autowired
    AdminService adminService;
    @Autowired
    SystemMessageService systemMessageService;

    /**
     * @api {get} /manager/signin
     * @apiName ManagerSignIn
     * @apiGroup Manager
     * @apiDescription 管理员登录功能，检查了账户是否存在与密码是否正确
     * @apiParam {String} account
     * @apiParam {String} password
     * @apiSuccessExample Response-Example:
     * {
     *  "error_msg":"password incorrect",
     *  "success":false
     * }
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "/signin",method = RequestMethod.GET)
    public String signIn(String account,String password)
    {
        return adminService.signIn(account, password);
    }

    /**
     * @api {get} /manager/signup
     * @apiName ManagerSignUp
     * @apiGroup Manager
     * @apiDescription 管理员注册，检查了账户名是否已经存在
     * @apiParam {String} account
     * @apiParam {String} password
     * @apiSuccessExample Response-Example:
     * {
     *     "error_msg":"account already exists",
     *     "success":false
     * }
     * @param account
     * @param password
     * @return
     */
    @RequestMapping(value = "signup",method = RequestMethod.GET)
    public String signUp(String account,String password)
    {
        if(account==""||password=="")
            return "need enough params";
        return adminService.signUp(account, password);
    }

    /**
     *
     * @param systemMessage
     * @return
     */
    @RequestMapping(value = "systemMessage/add",method =RequestMethod.POST)
    @ResponseBody
    public String addSystemMessage(@RequestBody SystemMessage systemMessage)
    {
        return systemMessageService.addSystemMessage(systemMessage);
    }

    /**
     *
     * @param number
     * @return
     */
    @RequestMapping(value = "systemMessage/find",method = RequestMethod.GET)
    public List<SystemMessage> findSystemMessage(Integer number)
    {
        return systemMessageService.findSystemMessage(number);
    }
}
