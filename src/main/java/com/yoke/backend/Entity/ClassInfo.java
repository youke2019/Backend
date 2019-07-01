package com.yoke.backend.Entity;

import java.util.List;

public class ClassInfo {
    private String classname;
    private String teacher_id;
    private String teacher_name;
    private String teachers;
    private int course_participants;
    private int begin_week;
    private int end_week;
    private List<ClassSegment> classSegments;

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

    public int getCourse_participants() {
        return course_participants;
    }

    public void setCourse_participants(int course_participants) {
        this.course_participants = course_participants;
    }

    public int getBegin_week() {
        return begin_week;
    }

    public void setBegin_week(int begin_week) {
        this.begin_week = begin_week;
    }

    public int getEnd_week() {
        return end_week;
    }

    public void setEnd_week(int end_week) {
        this.end_week = end_week;
    }

    public List<ClassSegment> getClassSegments() {
        return classSegments;
    }

    public void setClassSegments(List<ClassSegment> classSegments) {
        this.classSegments = classSegments;
    }
}

