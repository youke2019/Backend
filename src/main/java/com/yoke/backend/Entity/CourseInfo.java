package com.yoke.backend.Entity;

import java.util.List;

public class CourseInfo {
    private int course_id;
    private String course_name;
    private int course_hours;
    private float course_credits;
    private boolean general;
    private String general_type;
    private List<ClassInfo> classes;

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getCourse_hours() {
        return course_hours;
    }

    public void setCourse_hours(int course_hours) {
        this.course_hours = course_hours;
    }

    public float getCourse_credits() {
        return course_credits;
    }

    public void setCourse_credits(float course_credits) {
        this.course_credits = course_credits;
    }

    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    public String getGeneral_type() {
        return general_type;
    }

    public void setGeneral_type(String general_type) {
        this.general_type = general_type;
    }

    public List<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassInfo> classes) {
        this.classes = classes;
    }
}
