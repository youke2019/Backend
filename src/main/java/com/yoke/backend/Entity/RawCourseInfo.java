package com.yoke.backend.Entity;

import com.alibaba.fastjson.annotation.JSONField;

public class RawCourseInfo {
    @JSONField(name = "kkbm_id")
    private int department_id;

    @JSONField(name = "jxbmc")
    private String class_name;

    @JSONField(name = "jxb_id")
    private String class_id;

    @JSONField(name = "xkrs")
    private int chosen_number;

    @JSONField(name = "xf")
    private float credits;

    @JSONField(name = "kcdm")
    private String course_id;

    @JSONField(name = "xkbz")
    private String notes;

    @JSONField(name = "xqm")
    private int semester_id;  /*1:3, 2:12, summer:16*/

    @JSONField(name = "kcap")
    private String course_time_unparsed;

    @JSONField(name = "xnm")
    private int year;

    @JSONField(name = "rkjs")
    private String teacher;

    @JSONField(name = "jsxx")
    private String teacher_info;

    @JSONField(name = "kkbm")
    private String department_name;

    @JSONField(name = "xs")
    private int hours;

    @JSONField(name = "kcmc")
    private String course_name;

    @JSONField(name = "nj")
    private int student_grade;

    @JSONField(name = "row_id")
    private int row_id;

    @JSONField(name = "sftsk")
    private String general_course;

    @JSONField(name = "totalresult")
    private int total_result;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public int getChosen_number() {
        return chosen_number;
    }

    public void setChosen_number(int chosen_number) {
        this.chosen_number = chosen_number;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getSemester_id() {
        return semester_id;
    }

    public void setSemester_id(int semester_id) {
        this.semester_id = semester_id;
    }

    public String getCourse_time_unparsed() {
        return course_time_unparsed;
    }

    public void setCourse_time_unparsed(String course_time_unparsed) {
        this.course_time_unparsed = course_time_unparsed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher_info() {
        return teacher_info;
    }

    public void setTeacher_info(String teacher_info) {
        this.teacher_info = teacher_info;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getStudent_grade() {
        return student_grade;
    }

    public void setStudent_grade(int student_grade) {
        this.student_grade = student_grade;
    }

    public int getRow_id() {
        return row_id;
    }

    public void setRow_id(int row_id) {
        this.row_id = row_id;
    }

    public String getGeneral_course() {
        return general_course;
    }

    public void setGeneral_course(String general_course) {
        this.general_course = general_course;
    }

    public int getTotal_result() {
        return total_result;
    }

    public void setTotal_result(int total_result) {
        this.total_result = total_result;
    }
}
