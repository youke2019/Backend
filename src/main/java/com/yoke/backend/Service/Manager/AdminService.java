package com.yoke.backend.Service.Manager;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface AdminService {
    String signIn(String account,String password);
    String signUp(String account,String password);
}
