package com.yoke.backend.repository;

import com.yoke.backend.Entity.Course.CourseRecommendModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
public interface CourseRecommendRepository extends JpaRepository<CourseRecommendModel, Long> {

}
