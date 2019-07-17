package com.yoke.backend.DaoImpl.Course;

import com.yoke.backend.Dao.Course.ClassDao;
import com.yoke.backend.Entity.Course.ClassInfo;
import com.yoke.backend.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/4
 * @description:
 **/
@Repository
public class ClassDaoImpl implements ClassDao {
    @Autowired
    ClassRepository classRepository;

    @Override
    public List<ClassInfo> findAll()
    {
        return classRepository.findAll();
    }


}
