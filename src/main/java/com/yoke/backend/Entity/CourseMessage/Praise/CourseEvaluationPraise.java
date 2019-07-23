package com.yoke.backend.Entity.CourseMessage.Praise;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Entity
@Table(name="course_evaluate_praise",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_evaluate_praise_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseEvaluationPraise {
    private Integer course_evaluate_praise_id=0;
    private String user_id;
    private Integer course_evaluate_id;
    public CourseEvaluationPraise(){}

    public CourseEvaluationPraise(Integer course_evaluate_id,String user_id)
    {
        this.course_evaluate_id=course_evaluate_id;
        this.user_id=user_id;
        this.course_evaluate_praise_id=0;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "course_evaluate_id")
    public Integer getCourse_evaluate_id() {
        return course_evaluate_id;
    }

    @Id
    @Column(name = "course_evaluate_praise_id")
    public Integer getCourse_evaluate_praise_id() {
        return course_evaluate_praise_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCourse_evaluate_id(Integer course_evaluate_id) {
        this.course_evaluate_id = course_evaluate_id;
    }

    public void setCourse_evaluate_praise_id(Integer course_evaluate_praise_id) {
        this.course_evaluate_praise_id = course_evaluate_praise_id;
    }
}
