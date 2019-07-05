package com.yoke.backend.Service;


import com.yoke.backend.Entity.User;

public interface UserService {
    User GetUserByJaccountID(String jaccount);

    User GetUserByID(String id);

    void save(User user);

    void generateUserIfNoUserLike(User user);
}
