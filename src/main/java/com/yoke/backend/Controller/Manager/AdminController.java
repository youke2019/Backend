package com.yoke.backend.Controller.Manager;

import com.yoke.backend.Service.Manager.AdminService;
import com.yoke.backend.Service.Manager.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
     *
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
     *
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
}
