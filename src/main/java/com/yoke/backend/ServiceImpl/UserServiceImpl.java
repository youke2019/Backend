package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User GetUserByID(String id) {
        return userDao.findUserByID(id);

    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void generateUserIfNoUserLike(User user) {
        if (user == null) {
            System.out.println("In generateUserIfNoUserLike(user): input user is null");
            return;
        }
        if (user.getId() == null) {
            System.out.println("error: user must have ID"); //todo : implement this with java exception.
            return;
        }
        userDao.save(user); //Is it necessary to Update Information ?
    }
}
