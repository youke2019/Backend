package com.yoke.backend.Entity.Course;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/30
 * @description:
 **/
@Entity
@Table(name="course_recommend_data_model",schema = "yoke",catalog = "")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseRecommendModel {
    private long recommend_id;
    private long user_id;
    private long course_id;
    private long evaluate_time;
    private Integer evaluate_point;

    public CourseRecommendModel(){}

    public CourseRecommendModel(long user_id,long course_id,Integer evaluate_point,long evaluate_time)
    {
        this.recommend_id=0;
        this.user_id=user_id;
        this.course_id=course_id;
        this.evaluate_point=evaluate_point;
        this.evaluate_time= evaluate_time;
    }

    @Basic
    @Column(name = "evaluate_point")
    public Integer getEvaluate_point() {
        return evaluate_point;
    }

    @Basic
    @Column(name = "lcourse_id")
    public long getCourse_id() {
        return course_id;
    }

    @Basic
    @Column(name = "evaluate_time")
    public long getEvaluate_time() {
        return evaluate_time;
    }

    @Id
    @Column(name = "recommend_id")
    public long getRecommend_id() {
        return recommend_id;
    }

    @Basic
    @Column(name = "user_id")
    public long getUser_id() {
        return user_id;
    }

    public void setEvaluate_point(Integer evaluate_point) {
        this.evaluate_point = evaluate_point;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public void setEvaluate_time(long evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public void setRecommend_id(long recommend_id) {
        this.recommend_id = recommend_id;
    }
}
