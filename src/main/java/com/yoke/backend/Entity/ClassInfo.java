package com.yoke.backend.Entity;

import java.util.List;

public class ClassInfo {
    private String course_id;
    private String classname;
    private String teacher_id;
    private String teacher_name;
    private String teachers;
    private Integer course_participants;
    private List<ClassSegment> classSegments;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeachers() {
        return teachers;
    }

    public void setTeachers(String teachers) {
        this.teachers = teachers;
    }

    public Integer getCourse_participants() {
        return course_participants;
    }

    public void setCourse_participants(Integer course_participants) {
        this.course_participants = course_participants;
    }

    public List<ClassSegment> getClassSegments() {
        return classSegments;
    }

    public void setClassSegments(List<ClassSegment> classSegments) {
        this.classSegments = classSegments;
    }
}

