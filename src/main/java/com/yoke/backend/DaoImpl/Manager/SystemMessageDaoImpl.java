package com.yoke.backend.DaoImpl.Manager;

import com.yoke.backend.Dao.Manager.SystemMessageDao;
import com.yoke.backend.Entity.Manager.SystemMessage;
import com.yoke.backend.repository.Manager.SystemMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Repository
public class SystemMessageDaoImpl implements SystemMessageDao {
    @Autowired
    SystemMessageRepository systemMessageRepository;

    public void save(SystemMessage systemMessage)
    {
        systemMessageRepository.save(systemMessage);
    }

    public List<SystemMessage> findSystemMessage(Integer number)
    {
        return systemMessageRepository.findSystemMessage(number);
    }

    public void delete(Integer message_id)
    {
        systemMessageRepository.deleteById(message_id);
    }
}
