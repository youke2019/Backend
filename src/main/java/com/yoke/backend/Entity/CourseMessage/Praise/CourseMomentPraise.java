package com.yoke.backend.Entity.CourseMessage.Praise;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.yoke.backend.Entity.CourseMessage.CourseMoment;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Entity
@Table(name="video_praise",schema = "yoke",catalog = "")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseMomentPraise {
    private Integer video_praise_id;
    private String user_id;
    private Integer video_id;

    public CourseMomentPraise()
    {

    }

    public CourseMomentPraise(Integer video_id,String user_id)
    {
        this.video_id=video_id;
        this.user_id=user_id;
        this.video_praise_id=0;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    @Basic
    @Column(name = "video_id")
    public Integer getVideo_id() {
        return video_id;
    }

    @Id
    @Column(name = "video_praise_id")
    public Integer getVideo_praise_id() {
        return video_praise_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
    }

    public void setVideo_praise_id(Integer video_praise_id) {
        this.video_praise_id = video_praise_id;
    }
}
