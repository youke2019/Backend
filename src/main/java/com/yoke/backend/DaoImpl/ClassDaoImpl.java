package com.yoke.backend.DaoImpl;

import com.yoke.backend.Dao.ClassDao;
import com.yoke.backend.Entity.ClassInfo;
import com.yoke.backend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/4
 * @description:
 **/
@Service
public class ClassDaoImpl implements ClassDao {
    @Autowired
    ClassRepository classRepository;

    @Override
    public List<ClassInfo> findAll()
    {
        return classRepository.findAll();
    }


}
