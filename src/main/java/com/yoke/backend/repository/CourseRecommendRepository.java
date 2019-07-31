package com.yoke.backend.repository;

import com.yoke.backend.Entity.Course.CourseRecommendModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
@Repository
public interface CourseRecommendRepository extends JpaRepository<CourseRecommendModel, Long> {

}
