package com.yoke.backend.repository;
import com.yoke.backend.Entity.CourseInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/3
 * @description:
 **/
public interface CourseRepository extends JpaRepository<CourseInfo,Integer> {

}
