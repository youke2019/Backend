package com.yoke.backend.Dao;

import com.yoke.backend.Entity.User.User;

public interface UserDao {
    User findUserByJaccount(String jaccount);

    void save(User user);
}
