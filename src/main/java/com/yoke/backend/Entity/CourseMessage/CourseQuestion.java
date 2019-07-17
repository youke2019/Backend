package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestioinPraise;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/16
 * @description:
 **/
@Entity
@Table(name="question",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "question_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseQuestion {
    private Integer question_id;
    private String user_id;
    private String course_id;
    private String question_content;
    private String question_time;
    private String question_isbanned;
    private Integer question_praise_point=0;
    private List<CourseAnswer>  courseAnswerList=new ArrayList<>();
    private List<CourseQuestioinPraise> courseQuestioinPraiseList=new ArrayList<>();
    private Boolean currentUserPraise=false;

    @Transient
    public Boolean getCurrentUserPraise() {
        return currentUserPraise;
    }

    public void setCurrentUserPraise(Boolean currentUserPraise) {
        this.currentUserPraise = currentUserPraise;
    }

    @Id
    @Column(name = "question_id")
    public Integer getQuestion_id() {
        return question_id;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    @Basic
    @Column(name = "question_content")
    public String getQuestion_content() {
        return question_content;
    }

    @Basic
    @Column(name = "question_time")
    public String getQuestion_time() {
        return question_time;
    }

    @Basic
    @Column(name = "question_isbanned")
    public String getQuestion_isbanned() {
        return question_isbanned;
    }

    @Basic
    @Column(name = "question_praise_point")
    public Integer getQuestion_praise_point() {
        return question_praise_point;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public void setQuestion_time(String question_time) {
        this.question_time = question_time;
    }

    public void setQuestion_isbanned(String question_isbanned) {
        this.question_isbanned = question_isbanned;
    }

    public void setQuestion_praise_point(Integer question_praise_point) {
        this.question_praise_point = question_praise_point;
    }
    @OneToMany(mappedBy = "question_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<CourseAnswer> getCourseAnswerList() {
        return courseAnswerList;
    }

    public void setCourseAnswerList(List<CourseAnswer> courseAnswerList) {
        this.courseAnswerList = courseAnswerList;
    }

    @OneToMany(mappedBy = "question_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<CourseQuestioinPraise> getCourseQuestioinPraiseList() {
        return courseQuestioinPraiseList;
    }

    public void setCourseQuestioinPraiseList(List<CourseQuestioinPraise> courseQuestioinPraiseList) {
        this.courseQuestioinPraiseList = courseQuestioinPraiseList;
    }
}
