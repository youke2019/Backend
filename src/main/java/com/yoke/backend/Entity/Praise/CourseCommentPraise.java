package com.yoke.backend.Entity.Praise;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
@Entity
@Table(name="course_comment_praise",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class CourseCommentPraise {

    String user_id;
    Integer course_comment_id;
    Integer course_comment_praise_id;

    @Id
    @Column(name = "course_comment_praise_id")
    public Integer getCourse_comment_praise_id() {
        return course_comment_praise_id;
    }

    public void setCourse_comment_praise_id(Integer course_comment_praise_id) {
        this.course_comment_praise_id = course_comment_praise_id;
    }



    @Basic
    @Column(name = "course_comment_id")
    public Integer getCourse_comment_id() {
        return course_comment_id;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCourse_comment_id(Integer comment_id) {
        this.course_comment_id= comment_id;
    }
}
