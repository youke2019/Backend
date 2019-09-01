package com.yoke.backend.repository.User;

import com.yoke.backend.Entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(String id);

    @Transactional
    @Query(value = "update user u set u.banned = true where u.ID = ?1 ", nativeQuery = true)
    @Modifying
    void banUserById(String id);

    @Transactional
    @Query(value = "update user u set u.banned = false where u.ID = ?1 ", nativeQuery = true)
    @Modifying
    void unBanUserById(String id);

    @Transactional
    @Modifying
    void removeById(String id);

    @Query(value = "select count(*) from user", nativeQuery = true)
    int countAll();

    User findByNickname(String nickname);
}
