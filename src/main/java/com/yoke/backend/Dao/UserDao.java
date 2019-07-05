package com.yoke.backend.Dao;

import com.yoke.backend.Entity.User;

public interface UserDao {
    User findUserByJaccountID(String jaccount);

    User findUserByID(String id);

    void save(User user);
}
