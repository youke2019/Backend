package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseQuestionPraise;
import com.yoke.backend.Entity.Tools.TimeUtil;

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


    private Integer question_id=0;
    private String user_id="01231";
    private String course_id="11004";
    private String question_content;
    private String question_time= TimeUtil.CurrentTime();
    private Boolean question_isbanned=false;
    private Integer question_praise_point=0;
    private List<CourseAnswer>  courseAnswerList=new ArrayList<>();
    private List<CourseQuestionPraise> courseQuestionPraiseList=new ArrayList<>();
    private Boolean current_user_praise=false;

    public CourseQuestion()
    {

    }
    public CourseQuestion(String course_id,String user_id,String question_content)
    {
        this.course_id=course_id;
        this.user_id=user_id;
        this.question_content=question_content;
        this.question_isbanned=false;
        this.question_id=0;
        this.question_praise_point=0;
        this.question_time=TimeUtil.CurrentTime();
        this.current_user_praise=false;
    }

    @Transient
    public Boolean getCurrent_user_praise() {
        return current_user_praise;
    }

    public void setCurrent_user_praise(Boolean current_user_praise) {
        this.current_user_praise = current_user_praise;
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
    public Boolean getQuestion_isbanned() {
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

    public void setQuestion_isbanned(Boolean question_isbanned) {
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
    public List<CourseQuestionPraise> getCourseQuestionPraiseList() {
        return courseQuestionPraiseList;
    }

    public void setCourseQuestionPraiseList(List<CourseQuestionPraise> courseQuestionPraiseList) {
        this.courseQuestionPraiseList = courseQuestionPraiseList;
    }
}
