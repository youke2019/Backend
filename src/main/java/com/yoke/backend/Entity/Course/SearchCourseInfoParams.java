package com.yoke.backend.Entity.Course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/4
 * @description:
 **/
public class SearchCourseInfoParams {
    private String course_id="";
    private String course_name="";
    private String teacher_name="";
    private List<Integer> course_types=Arrays.asList(0,1);
    private List<String> general_types=Arrays.asList("社会科学","人文学科","自然科学","工程科学与技术","");  /*
    需要将数据库中general_types为null的课程的general_types设为""*/
    private List<Integer> weekdays=Arrays.asList(1,2,3,4,5,6,7);
    private List<Integer> begin_secs=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
    private List<Integer> end_secs=Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
    private String building="";
    private List<Double> course_credits=new ArrayList<Double>(Arrays.asList(0.5,1.0,1.5,2.0,2.5,3.0,3.5,
            4.0,4.5,5.0,5.5,6.0,6.5,7.0,7.5,8.0,8.5,9.0,9.5,10.0,10.5,11.0,11.5,12.0,12.5,13.0,14.0,15.0,16.0,17.0,18.0,19.0,
            20.0,21.0,22.0,23.0,24.0,25.0));
    /*需要将数据库中的classroom 为空的值设置为未知*/
    /*将数据库中teacher_id,teacher_name为空的值设置为未知*/

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

    public List<Integer> getCourse_types() {
        return course_types;
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

    public List<Integer> getBegin_secs() {
        return begin_secs;
    }

    public void setCourse_types(List<Integer> course_types) {
        this.course_types = course_types;
    }

    public List<Integer> getEnd_secs() {
        return end_secs;
    }

    public void setBegin_secs(List<Integer> begin_secs) {
        this.begin_secs = begin_secs;
    }

    public void setEnd_secs(List<Integer> end_secs) {
        this.end_secs = end_secs;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public List<Double> getCourse_credits() {
        return course_credits;
    }

    public void setCourse_credits(List<Double> course_credits) {
        this.course_credits = course_credits;
    }
}
