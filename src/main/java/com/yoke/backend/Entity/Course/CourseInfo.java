package com.yoke.backend.Entity.Course;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"},ignoreUnknown = true)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "course_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseInfo {
    private String course_id;
    private String course_name;
    private Integer course_hours;
    private float course_credits;
    private boolean general;
    private String general_type;
    private String course_deptname;


    private List<ClassInfo> classes;

    @Basic
    @Column(name = "course_deptname")
    public String getCourse_deptname() {
        return course_deptname;
    }

    public void setCourse_deptname(String course_deptname) {
        this.course_deptname = course_deptname;
    }

    public CourseInfo() {
    }

    @Id
    @Column(name="course_id")
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourse_name() {
        return course_name;
    }


    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    @Basic
    @Column(name="course_hours")
    public Integer getCourse_hours() {
        return course_hours;
    }

    public void setCourse_hours(Integer course_hours) {
        this.course_hours = course_hours;
    }

    @Basic
    @Column(name="course_credits")
    public float getCourse_credits() {
        return course_credits;
    }

    public void setCourse_credits(float course_credits) {
        this.course_credits = course_credits;
    }

    @Basic
    @Column(name="general")
    public boolean isGeneral() {
        return general;
    }

    public void setGeneral(boolean general) {
        this.general = general;
    }

    @Basic()
    @Column(name="general_type")
    public String getGeneral_type() {
        return general_type;
    }

    public void setGeneral_type(String general_type) {
        this.general_type = general_type;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course_id", cascade = CascadeType.ALL)
    public List<ClassInfo> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassInfo> classes) {
        this.classes = classes;
    }
}
