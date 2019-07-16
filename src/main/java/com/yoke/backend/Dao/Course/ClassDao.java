package com.yoke.backend.Dao.Course;

import com.yoke.backend.Entity.Course.ClassInfo;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/4
 * @description:
 **/
public interface ClassDao {
    List<ClassInfo> findAll();

}
