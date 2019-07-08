package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User GetUserByID(String id) {
        return userDao.findUserByID(id);

    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void generateUserIfNoUserLike(User user) {
        if (user == null) {
            System.out.println("Error: user should not be null");
            return;
        }

        userDao.save(user); //Is it necessary to Update Information ?

    }

    @Override
    public void banUser(String id) {
        userDao.banUser(id);
    }

    @Override
    public void unBanUser(String id) {
        userDao.unBanUser(id);
    }
}
