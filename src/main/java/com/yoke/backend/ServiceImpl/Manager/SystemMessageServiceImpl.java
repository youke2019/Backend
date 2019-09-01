package com.yoke.backend.ServiceImpl.Manager;

import com.yoke.backend.Dao.Manager.SystemMessageDao;
import com.yoke.backend.Entity.Manager.SystemMessage;
import com.yoke.backend.Service.Manager.SystemMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Service
public class SystemMessageServiceImpl implements SystemMessageService {

    @Autowired
    SystemMessageDao systemMessageDao;

    public void addSystemMessage(SystemMessage systemMessage)
    {
        systemMessageDao.save(systemMessage);
    }

    public List<SystemMessage> findSystemMessage(Integer number)
    {
        return systemMessageDao.findSystemMessage(number);
    }
}
