package com.yoke.backend.Entity.CourseMessage;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.yoke.backend.Entity.CourseMessage.Praise.CourseEvaluationPraise;
import com.yoke.backend.Entity.Tools.TimeUtil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/22
 * @description:
 **/
@Entity
@Table(name="course_evaluate",schema = "yoke",catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "evaluate_id"
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseEvaluation {

    private Integer evaluate_id=0;
    private String evaluate_time= TimeUtil.CurrentTime();
    private String user_id="01231";
    private String course_id="11004";
    private Map evaluate_content;
    private Integer evaluate_point=0;
    private Integer evaluate_praise_point=0;
    private Boolean current_user_praise=false;
    List<CourseEvaluationPraise> courseEvaluationPraiseList=new ArrayList<>();

    public CourseEvaluation()
    {

    }
    public CourseEvaluation(String course_id,String user_id)
    {
        this.evaluate_id=0;
        this.user_id = user_id;
        this.course_id=course_id;
        this.evaluate_praise_point=0;
        this.evaluate_time=TimeUtil.CurrentTime();
    }

    @Id
    @Column(name = "course_evaluate_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getEvaluate_id() {
        return evaluate_id;
    }

    public void setEvaluate_id(Integer evaluate_id) {
        this.evaluate_id = evaluate_id;
    }

    @Basic
    @Column(name = "course_evaluate_time")
    public String getEvaluate_time() {
        return evaluate_time;
    }

    public void setEvaluate_time(String evaluate_time) {
        this.evaluate_time = evaluate_time;
    }

    @Basic
    @Column(name = "ID")
    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    @Transient
    public Map getEvaluate_content() {
        return evaluate_content;
    }

    public void setEvaluate_content(Map evaluate_content) {
        this.evaluate_content = evaluate_content;
    }

    @OneToMany(mappedBy = "course_evaluate_id",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    public List<CourseEvaluationPraise> getCourseEvaluationPraiseList() {
        return courseEvaluationPraiseList;
    }

    public void setCourseEvaluationPraiseList(List<CourseEvaluationPraise> courseEvaluationPraiseList) {
        this.courseEvaluationPraiseList = courseEvaluationPraiseList;
    }

    @Transient
    public Boolean getCurrent_user_praise() {
        return current_user_praise;
    }

    public void setCurrent_user_praise(Boolean current_user_praise) {
        this.current_user_praise = current_user_praise;

    }

    @Basic
    @Column(name = "course_evaluate_praise_point")
    public Integer getEvaluate_praise_point() {
        return evaluate_praise_point;
    }

    public void setEvaluate_praise_point(Integer evaluate_praise_point) {
        this.evaluate_praise_point = evaluate_praise_point;
    }

    @Basic
    @Column(name = "course_evaluate_point")
    public Integer getEvaluate_point() {
        return evaluate_point;
    }

    public void setEvaluate_point(Integer evaluate_point) {
        this.evaluate_point = evaluate_point;
    }
}
