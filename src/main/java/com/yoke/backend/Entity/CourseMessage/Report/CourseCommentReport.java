package com.yoke.backend.Entity.CourseMessage.Report;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Entity
@Table(name="course_comment_report",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_comment_report_id"
)
public class CourseCommentReport {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();
    private Integer course_comment_report_id=0;
    private Integer course_comment_id;
    private String user_id;
    private String course_comment_report_reason;
    private String course_comment_report_time=sdf.format(date);
    private Integer course_comment_report_ishandled;

    @Id
    @Column(name = "course_comment_report_id")
    public Integer getCourse_comment_report_id() {
        return course_comment_report_id;
    }

    public void setCourse_comment_report_id(Integer course_comment_report_id) {
        this.course_comment_report_id = course_comment_report_id;
    }

    @Basic
    @Column(name = "course_comment_id")
    public Integer getCourse_comment_id() {
        return course_comment_id;
    }

    public void setCourse_comment_id(Integer course_comment_id) {
        this.course_comment_id = course_comment_id;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "course_comment_report_reason")
    public String getCourse_comment_report_reason() {
        return course_comment_report_reason;
    }

    public void setCourse_comment_report_reason(String course_comment_report_reason) {
        this.course_comment_report_reason = course_comment_report_reason;
    }

    @Basic
    @Column(name = "course_comment_report_time")
    public String getCourse_comment_report_time() {
        return course_comment_report_time;
    }

    public void setCourse_comment_report_time(String course_comment_report_time) {
        this.course_comment_report_time = course_comment_report_time;
    }

    @Basic
    @Column(name = "course_comment_report_ishandled")
    public Integer getCourse_comment_report_ishandled() {
        return course_comment_report_ishandled;
    }

    public void setCourse_comment_report_ishandled(Integer course_comment_report_ishandled) {
        this.course_comment_report_ishandled = course_comment_report_ishandled;
    }
}
