package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/15
 * @description:
 **/
@Entity
@Table(name="course_evaluate",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_evaluate_id"
)
public class CourseEvaluation {
    private Integer course_evaluate_id;
    private String user_id;
    private String evaluate_time;
    private String evaluate_text;
    private Integer evaluate_point;
    private String course_id;

    @Id
    @Column(name = "course_evaluate_id")
    public Integer getCourse_evaluate_id() {
        return course_evaluate_id;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "course_evaluate_time")
    public String getEvaluate_time() {
        return evaluate_time;
    }

    @Basic
    @Column(name = "course_evaluate_text")
    public String getEvaluate_text() {
        return evaluate_text;
    }

    @Basic
    @Column(name = "course_evaluate_point")
    public Integer getEvaluate_point() {
        return evaluate_point;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_evaluate_id(Integer course_evaluate_id) {
        this.course_evaluate_id = course_evaluate_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    public void setEvaluate_text(String evaluate_text) {
        this.evaluate_text = evaluate_text;
    }

    public void setEvaluate_point(Integer evaluate_point) {
        this.evaluate_point = evaluate_point;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }
}
