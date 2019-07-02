package com.yoke.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="course_class",schema = "yoke2",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "class_name"
)
public class ClassInfo {
    private String classname;
    private String teacher_id;
    private String teacher_name;
    private String teachers;
    private String course_id;
    private int course_participants;
    private int begin_week;
    private int end_week;
    private List<ClassSegment> classSegments;

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
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
    @Column(name="teacher_id")
    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Basic
    @Column(name = "teacher_name")
    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    @Basic
    @Column(name="teachers")
    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    @Basic
    @Column(name="course_participants")
    public int getCourse_participants() {
        return course_participants;
    }

    public void setCourse_participants(int course_participants) {
        this.course_participants = course_participants;
    }

    @Basic
    @Column(name="begin_week")
    public int getBegin_week() {
        return begin_week;
    }

    public void setBegin_week(int begin_week) {
        this.begin_week = begin_week;
    }

    @Basic
    @Column(name="end_week")
    public int getEnd_week() {
        return end_week;
    }

    public void setEnd_week(int end_week) {
        this.end_week = end_week;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="class_segments",joinColumns = @JoinColumn(name = "classname"),inverseJoinColumns = @JoinColumn(name="classname"))
    public List<ClassSegment> getClassSegments() {
        return classSegments;
    }

    public void setClassSegments(List<ClassSegment> classSegments) {
        this.classSegments = classSegments;
    }
}

