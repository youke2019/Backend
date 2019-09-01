package com.yoke.backend.Entity.Manager;

import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/9/1
 * @description:
 **/
@Entity
@Table(name = "system_message",schema = "yoke")
public class SystemMessage {
    private Integer message_id=0;
    private Integer admin_id=0;
    private String content="";
    private String image_url="";
    private String time= TimeUtil.CurrentTime();

    @Basic
    @Column(name = "admin_id")
    public Integer getAdmin_id() {
        return admin_id;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    @Id
    @Column(name = "message_id")
    public Integer getMessage_id() {
        return message_id;
    }

    @Basic
    @Column(name = "image_url")
    public String getImage_url() {
        return image_url;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public void setMessage_id(Integer message_id) {
        this.message_id = message_id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
