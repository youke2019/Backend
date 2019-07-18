package com.yoke.backend.Entity.CourseMessage.Report;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/18
 * @description:
 **/
@Entity
@Table(name="answer_report",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "answer_report_id"
)
public class CourseAnswerReport {
    private Integer answer_report_id;
    private Integer answer_id;
    private String user_id;
    private String answer_report_reason;
    private String answer_report_time;
    private Integer answer_report_ishandled;

    @Id
    @Column(name = "answer_report_id")
    public Integer getAnswer_report_id() {
        return answer_report_id;
    }

    public void setAnswer_report_id(Integer answer_report_id) {
        this.answer_report_id = answer_report_id;
    }

    @Basic
    @Column(name = "answer_id")
    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
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
    @Column(name = "answer_report_reason")
    public String getAnswer_report_reason() {
        return answer_report_reason;
    }

    public void setAnswer_report_reason(String answer_report_reason) {
        this.answer_report_reason = answer_report_reason;
    }

    @Basic
    @Column(name = "answer_report_time")
    public String getAnswer_report_time() {
        return answer_report_time;
    }

    public void setAnswer_report_time(String answer_report_time) {
        this.answer_report_time = answer_report_time;
    }

    @Basic
    @Column(name = "answer_report_ishandled")
    public Integer getAnswer_report_ishandled() {
        return answer_report_ishandled;
    }

    public void setAnswer_report_ishandled(Integer answer_report_ishandled) {
        this.answer_report_ishandled = answer_report_ishandled;
    }
}
