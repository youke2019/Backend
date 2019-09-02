package com.yoke.backend.Entity.CourseMessage.Report;

import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/8/31
 * @description:
 **/
@Entity
@Table(name = "video_report",schema = "yoke",catalog = "")
public class CourseMomentReport {
    private Integer video_report_id=0;
    private Integer video_id;
    private String user_id;
    private String video_report_time= TimeUtil.CurrentTime();
    private String video_report_reason;
    private Integer video_report_ishandled=0;

    @Id
    @Column(name="video_report_id")
    public Integer getVideo_report_id() {
        return video_report_id;
    }

    public void setVideo_report_id(Integer video_report_id) {
        this.video_report_id = video_report_id;
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
    @Column(name = "video_report_time")
    public String getVideo_report_time() {
        return video_report_time;
    }

    public void setVideo_report_time(String video_report_time) {
        this.video_report_time = video_report_time;
    }

    @Basic
    @Column(name = "video_report_reason")
    public String getVideo_report_reason() {
        return video_report_reason;
    }

    public void setVideo_report_reason(String video_report_reason) {
        this.video_report_reason = video_report_reason;
    }

    @Basic
    @Column(name = "video_report_ishandled")
    public Integer getVideo_report_ishandled() {
        return video_report_ishandled;
    }

    public void setVideo_report_ishandled(Integer video_report_ishandled) {
        this.video_report_ishandled = video_report_ishandled;
    }
}
