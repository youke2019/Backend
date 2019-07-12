package com.yoke.backend.ServiceImpl;

import com.yoke.backend.Dao.UserDao;
import com.yoke.backend.Entity.User.User;
import com.yoke.backend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
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

    private String getRandomName() {
        int num = userDao.countAll();
        Random random = new Random(num);
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        sb.append("Yoke用户_");
        for (int i = 0; i < 5 || userDao.findByNickname(sb.toString()) != null; i++) {
            System.out.println(i);
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    @Override
    public void generateUserIfNoUserLike(User user) {
        if (user == null) {
            System.out.println("Error: user should not be null");
            return;
        }
        if (user.getId() == null) {
            System.out.println("Error: user's ID is compulsory");
            return;
        }
        if (user.getNickname() == null) {
            user.setNickname(getRandomName());
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

    @Override
    public void removeById(String id) {
        userDao.removeById(id);
    }

    @Override
    public int countAll() {
        return userDao.countAll();
    }

    @Override
    public User findByNickname(String nickname) {
        return userDao.findByNickname(nickname);
    }
}
