package com.yoke.backend.Entity.CourseMessage.Report;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Entity
@Table(name="question_report",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "question_report_id"
)
public class CourseQuestionReport {

    private Integer question_report_id=0;
    private Integer question_id;
    private String user_id;
    private String question_report_reason;
    private String question_report_time= TimeUtil.CurrentTime();
    private Integer question_report_ishandled=0;

    @Id
    @Column(name = "question_report_id")
    public Integer getQuestion_report_id() {
        return question_report_id;
    }

    public void setQuestion_report_id(Integer question_report_id) {
        this.question_report_id = question_report_id;
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
    @Column(name = "question_report_reason")
    public String getQuestion_report_reason() {
        return question_report_reason;
    }

    public void setQuestion_report_reason(String question_report_reason) {
        this.question_report_reason = question_report_reason;
    }

    @Basic
    @Column(name = "question_report_time")
    public String getQuestion_report_time() {
        return question_report_time;
    }

    public void setQuestion_report_time(String question_report_time) {
        this.question_report_time = question_report_time;
    }

    @Basic
    @Column(name = "question_report_ishandled")
    public Integer getQuestion_report_ishandled() {
        return question_report_ishandled;
    }

    public void setQuestion_report_ishandled(Integer question_report_ishandled) {
        this.question_report_ishandled = question_report_ishandled;
    }
}
