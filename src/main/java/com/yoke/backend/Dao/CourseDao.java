package com.yoke.backend.Dao;

import com.yoke.backend.Entity.CourseInfo;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/

public interface CourseDao {
    List<CourseInfo> findall();
}
