package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseCommentPraise;
import com.yoke.backend.Entity.CourseMessage.Report.CourseCommentReport;
import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;
import java.util.ArrayList;
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

    private Integer course_comment_id=0;
    private String course_id;
    private String course_comment_time= TimeUtil.CurrentTime();/*此处的初始化是为了post参数传入时设置默认参数*/
    private String course_comment_content;
    private String user_id;
    private Boolean isbanned=false;
    private Integer course_comment_praise_point=0;
    private Boolean current_user_praise=false;
    List<CourseCommentPraise> courseCommentPraises=new ArrayList<>();
    List<CourseCommentReport> courseCommentReportList=new ArrayList<>();
    List<CourseCommentReply> courseCommentReplyList=new ArrayList<>();

    public CourseComment(){

    }
    public CourseComment(String user_id,String course_id,String content){
        this.course_comment_id=0;
        this.course_comment_content=content;
        this.course_comment_time= TimeUtil.CurrentTime();
        this.course_id=course_id;
        this.user_id=user_id;
        this.isbanned=false;
        this.current_user_praise=false;
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

    @Transient
    public Boolean getCurrent_user_praise() {
        return current_user_praise;
    }

    public void setCurrent_user_praise(Boolean current_user_praise) {
        this.current_user_praise = current_user_praise;
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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course_comment_id",cascade = CascadeType.ALL)
    public List<CourseCommentReport> getCourseCommentReportList() {
        return courseCommentReportList;
    }

    public void setCourseCommentReportList(List<CourseCommentReport> courseCommentReportList) {
        this.courseCommentReportList = courseCommentReportList;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "course_comment_id",cascade = CascadeType.ALL)
    public List<CourseCommentReply> getCourseCommentReplyList() {
        return courseCommentReplyList;
    }

    public void setCourseCommentReplyList(List<CourseCommentReply> courseCommentReplyList) {
        this.courseCommentReplyList = courseCommentReplyList;
    }
}
