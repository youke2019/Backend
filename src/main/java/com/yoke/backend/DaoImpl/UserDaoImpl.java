package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User;
import com.yoke.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository repository;

    @Override
    public User findUserByJaccountID(String jaccount) {
        return repository.findUserByJaccount(jaccount);
    }

    @Override
    public User findUserByID(String id) {
        return repository.findUserById(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }
}
