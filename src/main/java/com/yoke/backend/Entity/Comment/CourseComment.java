package com.yoke.backend.Entity.Comment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/12
 * @description:
 **/
@Entity
@Table(name="course_comment",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_comment_id"
)
public class CourseComment {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();


    private Integer course_comment_id=0;
    private String course_id;
    private String course_comment_time=sdf.format(date);/*此处的初始化是为了post参数传入时设置默认参数*/
    private String course_comment_content;
    private Integer user_id;
    private Boolean isbanned=false;

    public CourseComment(){

    }
    public CourseComment(Integer user_id,String course_id,String content){
        this.course_comment_id=0;
        this.course_comment_content=content;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
        Date date = new Date();
        this.course_comment_time=sdf.format(date);
        this.course_id=course_id;
        this.user_id=user_id;
        this.isbanned=false;
    }

    @Id
    @Column(name = "course_comment_id")
    public Integer getCourse_comment_id() {
        return course_comment_id;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    @Basic
    @Column(name = "course_comment_time")
    public String getCourse_comment_time() {
        return course_comment_time;
    }

    @Basic
    @Column(name="course_comment_content")
    public String getCourse_comment_content() {
        return course_comment_content;
    }

    @Basic
    @Column(name = "ID")
    public Integer getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "isbanned")
    public Boolean getIsbanned() {
        return isbanned;
    }

    public void setIsbanned(Boolean isbanned) {
        this.isbanned = isbanned;
    }

    public void setCourse_comment_id(Integer course_comment_id) {
        this.course_comment_id = course_comment_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setCourse_comment_time(String course_comment_time) {
        this.course_comment_time = course_comment_time;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setCourse_comment_content(String course_comment_content) {
        this.course_comment_content = course_comment_content;
    }
}
