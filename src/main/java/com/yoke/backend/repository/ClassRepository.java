package com.yoke.backend.repository;

import com.yoke.backend.Entity.Course.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
public interface ClassRepository extends JpaRepository<ClassInfo,Integer> {
}
