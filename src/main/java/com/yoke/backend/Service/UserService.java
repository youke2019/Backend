package com.yoke.backend.Service;


import com.yoke.backend.Entity.User.User;

public interface UserService {
    User GetUserByJaccount(String jaccount);

    void save(User user);

    void generateUserIfNoUserLike(User user);
}
