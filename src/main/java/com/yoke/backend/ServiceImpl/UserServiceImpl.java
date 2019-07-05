package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User GetUserByJaccountID(String jaccount) {
        return userDao.findUserByJaccountID(jaccount);

    }

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
        User userByJaccountID = userDao.findUserByJaccountID(user.getJaccount());
        if (userByJaccountID == null) {
            user.setId("newUserId"); //TODO : id generator
            userDao.save(user);
        } else {
            userByJaccountID.setMajor(user.getMajor());
            userByJaccountID.setDepartment(user.getDepartment());
            userByJaccountID.setName(user.getName());
            userDao.save(user); //Is it necessary to Update Infomation ?
        }
    }
}
