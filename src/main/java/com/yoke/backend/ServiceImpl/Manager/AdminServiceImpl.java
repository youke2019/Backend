package com.yoke.backend.ServiceImpl.Manager;

import com.alibaba.fastjson.JSONObject;
import com.yoke.backend.Dao.Manager.AdminDao;
import com.yoke.backend.Entity.Manager.Admin;
import com.yoke.backend.Service.Manager.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    public String signIn(String account,String password)
    {
        List<Admin> admins;
        JSONObject result=new JSONObject();
        admins=adminDao.findByAccount(account);
        if(admins.size()==0)
        {
            result.put("success",false);
            result.put("error_msg","account not exists");
            return result.toJSONString();
        }
        if(!password.equals(admins.get(0).getPassword()))
        {
            result.put("success",false);
            result.put("error_msg","password incorrect");
            return result.toJSONString();
        }
        result.put("success",true);
        return result.toJSONString();
    }

    public String signUp(String account,String password)
    {
        JSONObject result=new JSONObject();
        if(adminDao.findByAccount(account).size()!=0)
        {
            result.put("success",false);
            result.put("error_msg","account already exists");
            return result.toJSONString();
        }
        Admin admin=new Admin(account,password);
        adminDao.save(admin);
        result.put("success",true);
        return result.toJSONString();
    }
}
