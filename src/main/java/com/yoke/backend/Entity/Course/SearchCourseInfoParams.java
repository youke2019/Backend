package com.yoke.backend.Entity.Course;

import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/4
 * @description:
 **/
public class SearchCourseInfoParams {
    private String course_id;
    private String course_name;
    private String teachaer_name;
    private List<String> course_types;
    private List<String> general_types;
    private List<Integer> weekdays;
    private List<Integer> class_secs;
    private List<String> buildings;
    private List<Integer> course_credits;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<String> getCourse_types() {
        return course_types;
    }

    public void setCourse_types(List<String> course_types) {
        this.course_types = course_types;
    }

    public List<String> getGeneral_types() {
        return general_types;
    }

    public void setGeneral_types(List<String> general_types) {
        this.general_types = general_types;
    }

    public List<Integer> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<Integer> weekdays) {
        this.weekdays = weekdays;
    }

    public List<Integer> getClass_secs() {
        return class_secs;
    }

    public void setClass_secs(List<Integer> class_secs) {
        this.class_secs = class_secs;
    }

    public List<String> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<String> buildings) {
        this.buildings = buildings;
    }

    public String getTeachaer_name() {
        return teachaer_name;
    }

    public void setTeachaer_name(String teachaer_name) {
        this.teachaer_name = teachaer_name;
    }

    public List<Integer> getCourse_credits() {
        return course_credits;
    }

    public void setCourse_credits(List<Integer> course_credits) {
        this.course_credits = course_credits;
    }
}
