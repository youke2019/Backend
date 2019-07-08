package com.yoke.backend.Service;


import com.yoke.backend.Entity.User.User;

public interface UserService {
    User GetUserByID(String id);

    void save(User user);

    void generateUserIfNoUserLike(User user);
}
