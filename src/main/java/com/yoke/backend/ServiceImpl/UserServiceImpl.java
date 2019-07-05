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
    public User GetUserByJaccount(String jaccount) {
        return userDao.findUserByJaccount(jaccount);

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
        User userByJaccountID = userDao.findUserByJaccount(user.getJaccount());
        if (userByJaccountID == null) {
            userDao.save(user);
        } else {
            userByJaccountID.setMajor(user.getMajor());
            userByJaccountID.setDepartment(user.getDepartment());
            userByJaccountID.setName(user.getName());
            userDao.save(user); //Is it necessary to Update Information ?
        }
    }
}
