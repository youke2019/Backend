package com.yoke.backend.DaoImpl.User;

import com.yoke.backend.Dao.User.UserDao;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.repository.User.UserRepository;
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

    @Override
    public void removeById(String id) {
        repository.removeById(id);
    }

    @Override
    public int countAll() {

        return repository.countAll();
    }

    @Override
    public User findByNickname(String nickname) {
        return repository.findByNickname(nickname);
    }
}
