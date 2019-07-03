package com.yoke.backend.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="course_class",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "classname"
)
public class ClassInfo {
    private String course_id;
    private String classname;
    private String teacher_id;
    private String teacher_name;
    private String teachers;
    private Integer course_participants;
    private List<ClassSegment> classSegments;


    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }


    @Id
    @Column(name = "classname")
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
    public Integer getCourse_participants() {
        return course_participants;
    }

    public void setCourse_participants(Integer course_participants) {
        this.course_participants = course_participants;
    }


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="class_segments",joinColumns = @JoinColumn(name = "classname"),inverseJoinColumns = @JoinColumn(name="class_sec_id"))
    public List<ClassSegment> getClassSegments() {
        return classSegments;
    }

    public void setClassSegments(List<ClassSegment> classSegments) {
        this.classSegments = classSegments;
    }
}

