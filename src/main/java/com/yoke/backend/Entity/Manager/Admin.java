package com.yoke.backend.Entity.Manager;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Entity
@Table(name = "admins",schema = "yoke")
public class Admin {
    private Integer admin_id;
    private String account;
    private String password;

    public Admin(){}

    public Admin(String account,String password)
    {
        this.account=account;
        this.password=password;
        this.admin_id=0;
    }

    @Id
    @Column(name = "admin_id")
    public Integer getAdmin_id() {
        return admin_id;
    }

    @Basic
    @Column(name = "account")
    public String getAccount() {
        return account;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }
}
