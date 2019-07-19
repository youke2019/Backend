package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Entity
@Table(name="video_comment",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "video_comment_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseMomentComment {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();

    private Integer video_comment_id;
    private Integer video_id;
    private String user_id;
    private String video_comment_content;
    private String video_comment_time=sdf.format(date);
    private Boolean isbanned=false;

    @Id
    @Column(name = "video_comment_id")
    public Integer getVideo_comment_id() {
        return video_comment_id;
    }

    public void setVideo_comment_id(Integer video_comment_id) {
        this.video_comment_id = video_comment_id;
    }

    @Basic
    @Column(name = "video_id")
    public Integer getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Integer video_id) {
        this.video_id = video_id;
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
    @Column(name = "video_comment_content")
    public String getVideo_comment_content() {
        return video_comment_content;
    }

    public void setVideo_comment_content(String video_comment_content) {
        this.video_comment_content = video_comment_content;
    }

    @Basic
    @Column(name = "video_comment_time")
    public String getVideo_comment_time() {
        return video_comment_time;
    }

    public void setVideo_comment_time(String video_comment_time) {
        this.video_comment_time = video_comment_time;
    }

    @Basic
    @Column(name = "isbanned")
    public Boolean getIsbanned() {
        return isbanned;
    }

    public void setIsbanned(Boolean isbanned) {
        this.isbanned = isbanned;
    }
}
