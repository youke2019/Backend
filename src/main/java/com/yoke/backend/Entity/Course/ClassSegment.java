package com.yoke.backend.Entity.Course;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name="class_segments",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "class_sec_id"
)
public class ClassSegment {
    private Integer class_sec_id = 0;
    private String classname;
    private String classroom;
    private Integer begin_week;
    private Integer end_week;
    private Integer begin_sec;
    private Integer end_sec;
    private Integer week;
    private Character odd_or_even;

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

    @Id
    @Column(name="class_sec_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getClass_sec_id() {
        return class_sec_id;
    }

    public void setClass_sec_id(Integer class_sec_id) {
        this.class_sec_id = class_sec_id;
    }

    @Basic
    @Column(name="begin_week")
    public Integer getBegin_week() {
        return begin_week;
    }

    @Basic
    @Column(name = "odd_or_even")
    public Character getOdd_or_even() {
        return odd_or_even;
    }

    public void setOdd_or_even(Character odd_or_even) {
        this.odd_or_even = odd_or_even;
    }

    public void setBegin_week(Integer begin_week) {
        this.begin_week = begin_week;
    }

    @Basic
    @Column(name = "end_week")
    public Integer getEnd_week() {
        return end_week;
    }

    public void setEnd_week(Integer end_week) {
        this.end_week = end_week;
    }


    @JoinColumn(name = "classname")
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    @Basic
    @Column(name = "classroom")
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
