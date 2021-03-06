package com.yoke.backend.repository.Manager;

import com.yoke.backend.Entity.Manager.SystemMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface SystemMessageRepository extends JpaRepository<SystemMessage,Integer> {
    @Query(value = "select * from system_message order by message_id desc limit ?1 ",nativeQuery = true)
    List<SystemMessage> findSystemMessage(Integer number);
}
