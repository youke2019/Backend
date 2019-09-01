package com.yoke.backend.repository.Manager;

import com.yoke.backend.Entity.Manager.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface AdminRepository extends JpaRepository<Admin,Integer> {
    @Query(value = "select * from admins where account=?1",nativeQuery = true)
    List<Admin> findByaccount(String account);
}
