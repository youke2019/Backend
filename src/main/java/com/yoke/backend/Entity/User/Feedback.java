package com.yoke.backend.Entity.User;

import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Entity
@Table(name = "feedback", schema = "yoke", catalog = "")
public class Feedback {
    private Integer feedback_id=0;
    private String user_id="";
    private String content="";
    private String time= TimeUtil.CurrentTime();

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    @Id
    @Column(name = "feedback_id")
    public Integer getFeedback_id() {
        return feedback_id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFeedback_id(Integer feedback_id) {
        this.feedback_id = feedback_id;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
