package com.yoke.backend.DaoImpl.Manager;

import com.yoke.backend.Dao.Manager.AdminDao;
import com.yoke.backend.Entity.Manager.Admin;
import com.yoke.backend.repository.Manager.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Repository
public class AdminDaoImpl implements AdminDao {
    @Autowired
    AdminRepository adminRepository;

    public List<Admin> findByAccount(String account)
    {
        return adminRepository.findByaccount(account);
    }

    public void save(Admin admin)
    {
        adminRepository.save(admin);
    }
}
