package com.yoke.backend.Service.User;


import com.yoke.backend.Entity.User.User;

import java.util.List;

public interface UserService {
    User GetUserByID(String id);

    List<User> findAll();
    void save(User user);
    void generateUserIfNoUserLike(User user);

    void banUser(String id);

    void unBanUser(String id);

    void removeById(String id);

    int countAll();

    User findByNickname(String nickname);
}
