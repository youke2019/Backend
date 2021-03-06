package com.yoke.backend.Dao.User;

import com.yoke.backend.Entity.User.User;

import java.util.List;

public interface UserDao {
    User findUserByID(String id);

    List<User> findAll();
    void save(User user);

    void banUser(String id);

    void unBanUser(String id);

    void removeById(String id);

    int countAll();

    User findByNickname(String nickname);
}
