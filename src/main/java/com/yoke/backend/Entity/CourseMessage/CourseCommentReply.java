package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Entity
@Table(name="course_comment_reply",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_comment_reply_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseCommentReply {
    private Integer course_comment_reply_id=0;
    private String course_comment_reply_content="";
    private String user_id;
    private Integer course_comment_id;

    public CourseCommentReply(){}
    public CourseCommentReply(Integer course_comment_id,String user_id,String course_comment_reply_content)
    {
        this.course_comment_id=course_comment_id;
        this.user_id=user_id;
        this.course_comment_reply_id=0;
        this.course_comment_reply_content=course_comment_reply_content;
    }

    @Id
    @Column(name = "course_comment_reply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getCourse_comment_reply_id() {
        return course_comment_reply_id;
    }

    public void setCourse_comment_reply_id(Integer course_comment_reply_id) {
        this.course_comment_reply_id = course_comment_reply_id;
    }

    @Basic
    @Column(name = "course_comment_reply_content")
    public String getCourse_comment_reply_content() {
        return course_comment_reply_content;
    }

    public void setCourse_comment_reply_content(String course_comment_reply_content) {
        this.course_comment_reply_content = course_comment_reply_content;
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
    @Column(name = "course_comment_id")
    public Integer getCourse_comment_id() {
        return course_comment_id;
    }

    public void setCourse_comment_id(Integer course_comment_id) {
        this.course_comment_id = course_comment_id;
    }
}
