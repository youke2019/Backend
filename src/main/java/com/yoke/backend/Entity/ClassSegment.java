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
    private Integer begin_week;
    private Integer end_week;
    private Integer begin_sec;
    private Integer end_sec;
    private Integer week;
    private Character oddOrEven;

    public ClassSegment() {
    }

    public ClassSegment(String classroom, Integer begin_week, Integer end_week, Integer begin_sec, Integer end_sec, Integer week) {
        this.classroom = classroom;
        this.begin_week = begin_week;
        this.end_week = end_week;
        this.begin_sec = begin_sec;
        this.end_sec = end_sec;
        this.week = week;
    }

    public Integer getBegin_week() {
        return begin_week;
    }

    public Character getOddOrEven() {
        return oddOrEven;
    }

    public void setOddOrEven(Character oddOrEven) {
        this.oddOrEven = oddOrEven;
    }

    public void setBegin_week(Integer begin_week) {
        this.begin_week = begin_week;
    }

    public Integer getEnd_week() {
        return end_week;
    }

    public void setEnd_week(Integer end_week) {
        this.end_week = end_week;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

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
    public Integer getBegin_sec() {
        return begin_sec;
    }

    public void setBegin_sec(Integer begin_sec) {
        this.begin_sec = begin_sec;
    }

    @Basic
    @Column(name = "end_sec")
    public Integer getEnd_sec() {
        return end_sec;
    }

    public void setEnd_sec(Integer end_sec) {
        this.end_sec = end_sec;
    }

    @Basic
    @Column(name = "week")
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}
