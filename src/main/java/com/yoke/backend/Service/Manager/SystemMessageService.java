package com.yoke.backend.Service.Manager;

import com.yoke.backend.Entity.Manager.SystemMessage;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
public interface SystemMessageService {
    List<SystemMessage> findSystemMessage(Integer number);
    String addSystemMessage(SystemMessage systemMessage);
    String deleteSystemMessage(Integer message_id);
}
