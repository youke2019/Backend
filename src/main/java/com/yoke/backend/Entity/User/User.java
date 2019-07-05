package com.yoke.backend.Entity.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name = "user", schema = "yoke", catalog = "")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "jaccount"
)
public class User {
    private String jaccount;
    private String nickname;
    private String name;
    private String department;
    private String major;
    private Character sex;  /*m,f,u*/
    private Integer grade;

    @Basic
    @Column(name = "nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Id
    @Column(name = "jaccount", nullable = false)
    public String getJaccount() {
        return jaccount;
    }

    public void setJaccount(String jaccount) {
        this.jaccount = jaccount;
    }

    @Basic
    @Column(name = "sex")
    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "major")
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
