package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.Praise.CourseCommentPraise;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseComment {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();


    private Integer course_comment_id=0;
    private String course_id;
    private String course_comment_time=sdf.format(date);/*此处的初始化是为了post参数传入时设置默认参数*/
    private String course_comment_content;
    private String user_id;
    private Boolean isbanned=false;
    private Integer course_comment_praise_point=0;
    List<CourseCommentPraise> courseCommentPraises=new ArrayList<>();

    public CourseComment(){

    }
    public CourseComment(String user_id,String course_id,String content){
        this.course_comment_id=0;
        this.course_comment_content=content;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
        Date date = new Date();
        this.course_comment_time=sdf.format(date);
        this.course_id=course_id;
        this.user_id=user_id;
        this.isbanned=false;
        this.course_comment_praise_point=0;
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
    public String getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "course_comment_isbanned")
    public Boolean getIsbanned() {
        return isbanned;
    }

    @Basic
    @Column(name = "course_comment_praise_point")
    public Integer getCourse_comment_praise_point() {
        return course_comment_praise_point;
    }

    public void setCourse_comment_praise_point(Integer course_comment_praise_point) {
        this.course_comment_praise_point = course_comment_praise_point;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course_comment_id", cascade = CascadeType.ALL)
    public List<CourseCommentPraise> getCourseCommentPraises() {
        return courseCommentPraises;
    }

    public void setCourseCommentPraises(List<CourseCommentPraise> courseCommentPraises) {
        this.courseCommentPraises = courseCommentPraises;
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

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCourse_comment_content(String course_comment_content) {
        this.course_comment_content = course_comment_content;
    }
}