package com.yoke.backend.Entity.Course;

/**
 * @AUTHOR: Guozhi
 * @DATE : 2019/7/29
 * @description:
 **/
public class CourseRecommend {
    private String course_id;
    private String user_id;
    private Integer evaluate_point;

    public CourseRecommend(){}

    public CourseRecommend(String course_id, String user_id, Integer evaluate_point)
    {
        this.course_id=course_id;
        this.user_id=user_id;
        this.evaluate_point=evaluate_point;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getCourse_id() {
        return course_id;
    }

    public Integer getEvaluate_point() {
        return evaluate_point;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public void setEvaluate_point(Integer evaluate_point) {
        this.evaluate_point = evaluate_point;
    }
}
