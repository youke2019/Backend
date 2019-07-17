package com.yoke.backend.Entity.CourseMessage.Praise;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/17
 * @description:
 **/
@Entity
@Table(name="answer_praise",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "answer_praise_id"
)
public class CourseAnswerPraise {
    private Integer answer_praise_id;
    private String user_id;
    private Integer answer_id;

    @Id
    @Column(name = "answer_praise_id")
    public Integer getAnswer_praise_id() {
        return answer_praise_id;
    }

    public void setAnswer_praise_id(Integer answer_praise_id) {
        this.answer_praise_id = answer_praise_id;
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
    @Column(name = "answer_id")
    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }
}
