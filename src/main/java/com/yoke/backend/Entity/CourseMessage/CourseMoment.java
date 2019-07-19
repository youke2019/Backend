package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseMomentPraise;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/19
 * @description:
 **/
@Entity
@Table(name="video",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "video_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseMoment {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化时间
    Date date = new Date();

    private Integer video_id;
    private String user_id;
    private String post_time=sdf.format(date);
    private String post_text;
    private String video_url;
    private String video_type;
    private String image_url;
    private Boolean isbanned=false;
    private Integer video_praise_point=0;
    private Boolean current_user_praise=false;
    private List<CourseMomentComment> courseMomentCommentList=new ArrayList<>();
    private List<CourseMomentPraise> courseMomentPraiseList=new ArrayList<>();

    public CourseMoment()
    {}

    @Id
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
    @Column(name = "post_time")
    public String getPost_time() {
        return post_time;
    }

    public void setPost_time(String post_time) {
        this.post_time = post_time;
    }

    @Basic
    @Column(name = "post_text")
    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    @Basic
    @Column(name = "video_url")
    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    @Basic
    @Column(name = "type")
    public String getVideo_type() {
        return video_type;
    }

    public void setVideo_type(String video_type) {
        this.video_type = video_type;
    }

    @Basic
    @Column(name = "image_url")
    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Basic
    @Column(name = "isbanned")
    public Boolean getIsbanned() {
        return isbanned;
    }

    public void setIsbanned(Boolean isbanned) {
        this.isbanned = isbanned;
    }

    @Basic
    @Column(name = "video_praise_point")
    public Integer getVideo_praise_point() {
        return video_praise_point;
    }

    public void setVideo_praise_point(Integer video_praise_point) {
        this.video_praise_point = video_praise_point;
    }

    @Transient
    public Boolean getCurrent_user_praise() {
        return current_user_praise;
    }

    public void setCurrent_user_praise(Boolean current_user_praise) {
        this.current_user_praise = current_user_praise;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "video_id",cascade = CascadeType.ALL)
    public List<CourseMomentComment> getCourseMomentCommentList() {
        return courseMomentCommentList;
    }

    public void setCourseMomentCommentList(List<CourseMomentComment> courseMomentCommentList) {
        this.courseMomentCommentList = courseMomentCommentList;
    }

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "video_id",cascade = CascadeType.ALL)
    public List<CourseMomentPraise> getCourseMomentPraiseList() {
        return courseMomentPraiseList;
    }

    public void setCourseMomentPraiseList(List<CourseMomentPraise> courseMomentPraiseList) {
        this.courseMomentPraiseList = courseMomentPraiseList;
    }

}
