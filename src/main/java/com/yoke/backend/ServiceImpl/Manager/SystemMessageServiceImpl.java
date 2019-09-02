package com.yoke.backend.ServiceImpl.Manager;

import com.alibaba.fastjson.JSONObject;
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

    public String addSystemMessage(SystemMessage systemMessage)
    {
        JSONObject result=new JSONObject();
        if(systemMessage.getAdmin_id()==0||systemMessage.getContent()=="")
        {
            result.put("error_msg","lack of parameter");
            result.put("success",false);
            return result.toJSONString();
        }
        systemMessageDao.save(systemMessage);
        result.put("success",true);
        return result.toJSONString();
    }

    public List<SystemMessage> findSystemMessage(Integer number)
    {
        if(number<=0)
            return null;
        return systemMessageDao.findSystemMessage(number);
    }

    public String deleteSystemMessage(Integer message_id)
    {
        JSONObject result=new JSONObject();
        if(systemMessageDao.findSystemMessage(message_id).size()==0)
        {
            result.put("error_msg","id not exists");
            result.put("success",false);
            return result.toJSONString();
        }
        systemMessageDao.delete(message_id);
        result.put("success",true);
        return result.toJSONString();
    }
}
