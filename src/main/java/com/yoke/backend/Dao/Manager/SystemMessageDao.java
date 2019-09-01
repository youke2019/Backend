package com.yoke.backend.Dao.Manager;

import com.yoke.backend.Entity.Manager.SystemMessage;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface SystemMessageDao {
    void save(SystemMessage systemMessage);
    List<SystemMessage> findSystemMessage(Integer number);
}
