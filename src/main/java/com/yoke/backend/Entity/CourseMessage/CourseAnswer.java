package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseAnswerPraise;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Entity
@Table(name="answer",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "answer_id"
)
public class CourseAnswer {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();

    private Integer answer_id;
    private Integer question_id;
    private String user_id;
    private String answer_content;
    private String answer_time=sdf.format(date);
    private Boolean answer_isbanned=false;
    private Integer answer_praise_point=0;
    private Boolean current_user_praise=false;
    private List<CourseAnswerPraise> courseAnswerPraiseList=new ArrayList<>();

    public CourseAnswer()
    {

    }
    public CourseAnswer(Integer question_id,String user_id,String answer_content)
    {
        this.answer_id=0;
        this.question_id=question_id;
        this.user_id=user_id;
        this.answer_content=answer_content;
        this.answer_isbanned=false;
        this.answer_praise_point=0;
        this.current_user_praise=false;
        this.answer_time=sdf.format(date);
    }
    @Id
    @Column(name = "answer_id")
    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    @Basic
    @Column(name = "question_id")
    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
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
    @Column(name = "answer_content")
    public String getAnswer_content() {
        return answer_content;
    }

    public void setAnswer_content(String answer_content) {
        this.answer_content = answer_content;
    }

    @Basic
    @Column(name = "answer_time")
    public String getAnswer_time() {
        return answer_time;
    }

    public void setAnswer_time(String answer_time) {
        this.answer_time = answer_time;
    }

    @Basic
    @Column(name = "answer_isbanned")
    public Boolean getAnswer_isbanned() {
        return answer_isbanned;
    }

    public void setAnswer_isbanned(Boolean answer_isbanned) {
        this.answer_isbanned = answer_isbanned;
    }

    @Basic
    @Column(name = "answer_praise_point")
    public Integer getAnswer_praise_point() {
        return answer_praise_point;
    }

    public void setAnswer_praise_point(Integer answer_praise_point) {
        this.answer_praise_point = answer_praise_point;
    }

    @Transient
    public Boolean getCurrent_user_praise() {
        return current_user_praise;
    }

    public void setCurrent_user_praise(Boolean current_user_praise) {
        this.current_user_praise = current_user_praise;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "answer_id",cascade = CascadeType.ALL)
    public List<CourseAnswerPraise> getCourseAnswerPraiseList() {
        return courseAnswerPraiseList;
    }

    public void setCourseAnswerPraiseList(List<CourseAnswerPraise> courseAnswerPraiseList) {
        this.courseAnswerPraiseList = courseAnswerPraiseList;
    }
}
