package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository repository;

    @Override
    public User findUserByID(String id) {
        return repository.findUserById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void banUser(String id) {
        repository.banUserById(id);
    }

    @Override
    public void unBanUser(String id) {
        repository.unBanUserById(id);
    }
}
