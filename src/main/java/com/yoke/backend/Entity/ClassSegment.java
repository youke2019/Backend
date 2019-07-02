package com.yoke.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="class_segments",schema = "yoke1",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "classname"
)
public class ClassSegment {
    private String classname;
    private String classroom;
    private int begin_sec;
    private int end_sec;
    private int week;

    @Id
    @Column(name = "class_name")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Basic
    @Column(name = "class_room")
    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    @Basic
    @Column(name = "begin_sec")
    public int getBegin_sec() {
        return begin_sec;
    }

    public void setBegin_sec(int begin_sec) {
        this.begin_sec = begin_sec;
    }

    @Basic
    @Column(name = "end_sec")
    public int getEnd_sec() {
        return end_sec;
    }

    public void setEnd_sec(int end_sec) {
        this.end_sec = end_sec;
    }

    @Basic
    @Column(name = "week")
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }
}
