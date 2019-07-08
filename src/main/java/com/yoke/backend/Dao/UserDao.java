package com.yoke.backend.Dao;

import com.yoke.backend.Entity.User.User;

public interface UserDao {
    User findUserByID(String id);

    void save(User user);
}
