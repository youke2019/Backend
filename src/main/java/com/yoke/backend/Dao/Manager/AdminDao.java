package com.yoke.backend.Dao.Manager;

import com.yoke.backend.Entity.Manager.Admin;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface AdminDao {
    List<Admin> findByAccount(String account);
    void save(Admin admin);
}
